package javaserver.config;

public class ConfigurationManager {
  private  static ConfigurationManager myConfigurationManager;

  private static  Configuration myCurrentConfig;

  private ConfigurationManager(){}

  public static ConfigurationManager getInstance(){
      if(myConfigurationManager==null){
          myConfigurationManager = new ConfigurationManager();
      }
      return  myConfigurationManager;
  }

  public  void  loadConfiguration(String path){}
    public  void getCurrentConfiguration(){}


}
