import java.io.IOException;
import java.util.Scanner;

import configurations.Persist;
import configurations.Settings;
import exception.ConfigurationInitException;
import exception.FailedGetSettingException;
import exception.FailedLoadingConfigurationException;
import exception.FailedSavingConfigurationException;
import exception.FailedSetSettingException;
import exception.FailedWebServerTransitionException;
import exception.InvalidPortException;
import exception.WebServerStateException;
import webserver.WebServer;
import webserver.WebServerState;

public class Main {
	public static void main(String[] args) throws FailedLoadingConfigurationException, InvalidPortException, FailedSetSettingException, FailedSavingConfigurationException, IOException {
        Settings.init();
        WebServerState.init();
        Persist persist = Settings.persist;
        Scanner input = new Scanner(System.in);

        while(true) 
        {
            System.out.println("Run on port: ");
			int inputPort = input.nextInt();
			persist.setPort(inputPort);
			break;
        }

        new Thread(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    WebServer.runWebServer(persist.getPort());
                } 
                catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FailedGetSettingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    printServerSettingsMenu();

                    try {
                        switch (input.nextInt()) {
                            case 0:
                                WebServerState.setStopped();
                                break;
                            case 1:
                                WebServerState.setRunning();
                                break;
                            case 2:
                                WebServerState.setMaintenance();
                                break;
                            case 3:
                                System.exit(0);
                        }

                    } catch (FailedWebServerTransitionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }).start();
    }

    public static void printServerSettingsMenu(){
        System.out.println("*************** Server settings ***************");
        System.out.println("Current state: " + WebServerState.getWebServerState());
        System.out.println("* Set to state 0 (Stopped)");
        System.out.println("* Set to state 1 (Running)");
        System.out.println("* Set to state 2 (Maintenance)");
        System.out.println("* Exit program: 3");
        System.out.println("Enter your option:");
    }
}
