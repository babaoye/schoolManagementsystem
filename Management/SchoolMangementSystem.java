/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

/**
 *
 * @author USER1
 */
public class SchoolMangementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    LoadingPage splash=new LoadingPage();
      splash.setVisible(true);
     HelloPage pg=new HelloPage();
     
      try{
      for(int i=0;i<=100;i++){
          Thread.sleep(40);
          splash.loadrun.setText(Integer.toString(i)+"%");
          splash.loadingBar.setValue(i);
          splash.loadingBar2.setValue(i);
          if(i==100){
              splash.setVisible(false);
          pg.setVisible(true);
          }
          
      }
      }catch(Exception e){
      
      }
    }
    
}
