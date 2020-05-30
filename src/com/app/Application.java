package com.app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.ie.driver", "drivers/32/IEDriverServer.exe");
     	DesiredCapabilities cap = new DesiredCapabilities();
     	cap = DesiredCapabilities.internetExplorer();
     	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
         cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //disable protected mode settings
         cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true); //disable protected mode settings
         cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true); //disable protected mode settings
         cap.setCapability(
        		 InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
        		 true);
         String endpointurl = "http://test.sinarmasmsiglife.co.id:8800/E-LionsExtraMagna/";
	//	WebDriver driver = new InternetExplorerDriver(cap);
     	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), cap);


		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get(endpointurl);
        
        WebElement user = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='name']")));
        WebElement pass = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pass']")));
        WebElement button = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("btnLogin")));
        
        user.sendKeys("RANDY");
        pass.sendKeys("Randy123");
        button.click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("elions.png"));
       try {
        driver.navigate().to(endpointurl+"/bac/editspajnew.htm?data_baru=true&flagAwal=1&jenis_pemegang_polis=");
        Alert alert = driver.switchTo().alert();
        alert.accept();
       }catch(	NoAlertPresentException  e) {
    	   
       }
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("elions2.png"));
        WebElement kopispaj = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='kopiSPAJ']")));
        WebElement copyclik = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='Copy Data dari Spaj:']")));
        ((JavascriptExecutor) driver).executeScript("document.getElementsByName('flag_upload3')[0].checked=false");
        ((JavascriptExecutor) driver).executeScript("document.getElementsByName('flag_upload3')[0].onclick()");
		/*
		 * WebElement flagUpload3 = (new WebDriverWait(driver,
		 * 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//*[@name='flag_upload3']"))); if(flagUpload3.isSelected()) {
		 * flagUpload3.click(); }else {
		 * 
		 * }
		 */
        
        
        String sexttt = "0";
        kopispaj.sendKeys("09200077118");
        copyclik.click();
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("elions3.png"));
        
        
        WebElement pemegang_mcl_first = (new WebDriverWait(driver,
         		  10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
         				 "//*[@name='pemegang.mcl_first']")));
          pemegang_mcl_first.clear();
          pemegang_mcl_first.sendKeys("PEMEGANG"+random());
          
          WebElement pemegang_mspo_no_blanko = (new WebDriverWait(driver,
         		  10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
         				 "//*[@name='pemegang.mspo_no_blanko']")));
          pemegang_mspo_no_blanko.clear();
          pemegang_mspo_no_blanko.sendKeys("923423412364");
          
          Select hubunganPemegangTertanggung = new Select(driver.findElement(By.xpath("//*[@name='pemegang.lsre_id']")));
          
          hubunganPemegangTertanggung.selectByVisibleText("ANAK KANDUNG");
          
          ((JavascriptExecutor) driver).executeScript("document.getElementById('pemegang.mspe_date_birth').value='14/05/1984'");

          ((JavascriptExecutor) driver).executeScript("document.getElementById('_pemegang.mspe_date_birth').value='14/05/1984'");
       
          WebElement next = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target1']")));
          next.click();

          
          
          System.out.println("belum next ini");
          boolean errorPemegang = false;
          try {
      //    String actual_msg=driver.findElement(By.id("error")).getText();
          WebDriverWait wait = new WebDriverWait(driver, 2);
          WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("error")));
          System.out.println(el.getText());
          errorPemegang = true;
          }catch(Exception e) {
        	  errorPemegang = false;
        	  System.out.println("no error yaa");
          };
          
          boolean errorTertanggung = false;
          String tertanggung = "TERTANGGUNG"+random();
          if(!errorPemegang) {
        	  // tertanggung 

              WebElement tertanggung_mcl_first = (new WebDriverWait(driver,
               		  10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
               				 "//*[@name='tertanggung.mcl_first']")));
              tertanggung_mcl_first.clear();
              tertanggung_mcl_first.sendKeys(tertanggung);
              String tglLahirTT = "14/05/1984";
              ((JavascriptExecutor) driver).executeScript("document.getElementById('tertanggung.mspe_date_birth').value='"+tglLahirTT+"'");

              ((JavascriptExecutor) driver).executeScript("document.getElementById('_tertanggung.mspe_date_birth').value='"+tglLahirTT+"'");
              WebElement sextt = driver.findElement(By.name("tertanggung.mspe_sex"));
              sexttt = sextt.getAttribute("value");
           
              next = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target2']")));
              next.click();
               boolean errorPembayarPremi = false;
          
              if(!errorTertanggung) {
            	  next = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target3']")));
                  next.click();
                  
                  
                  if(!errorPembayarPremi)
                  {
                	  WebElement kode_produk = (new WebDriverWait(driver,
                       		  10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                       				 "//*[@name='datausulan.kodeproduk']")));
                	  kode_produk.clear();
                	  kode_produk.sendKeys("220");
                	 

                      ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.lsbs_id')[0].value='220'");
                      ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.lsbs_id')[0].onchange()");
					
					  ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.plan')[0].value='220~X1'");
					  
					   ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.plan')[0].onchange()");
                      
                    //  ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.plan')[0].removeAttribute('disabled')");
                      
                      
					/*
					 * Select plan = new
					 * Select(driver.findElement(By.xpath("//*[@name='datausulan.plan']")));
					 * 
					 * plan.selectByValue("212~X2");
					 */
                      
                	  
					   next = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target4']")));
			           next.click();
			           
			           
			           next = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Prev «' and @name='_target3']")));
			           next.click();
			           
			         //  next = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target4']")));
			          // next.click();

			           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.mspr_premium')[0].value='3000000'");

			           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.mspr_tsi')[0].value='50000000'");
			           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.mspr_tsi')[0].onchange()");
						  	  
			           
			           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('btnadd1')[0].click();");
					  	  
			           
			           WebDriverWait wait2= new WebDriverWait(driver, 10);
			           WebElement element = wait2.until(ExpectedConditions.elementToBeClickable(By.name("ride.plan_rider1")));
			           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ride.plan_rider1')[0].value='848~X72'");
			           	((JavascriptExecutor) driver).executeScript("document.getElementsByName('btnadd1x')[0].click();");
					  	  
					  	wait2= new WebDriverWait(driver, 10);
					  	element = wait2.until(ExpectedConditions.elementToBeClickable(By.name("ptx.nama1")));
					  	((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.nama1')[0].value='"+tertanggung+"'");
					  	
					  	
					  //	((JavascriptExecutor) driver).executeScript("document.getElementsByName('kelamin1')[0].checked=true;");
					  	final List<WebElement> radios = driver.findElements(By.name("kelamin1"));
					    for (WebElement radio : radios) {
					  		System.out.println("text:"+radio.getAttribute("value") +"==="+radio.getAttribute("value").contains(sexttt)+"sexxx:"+sexttt);
					  		//sexttt
					  		if(radio.getAttribute("value").contains(sexttt)) {
					  			
					  			radio.click();
					  			//((JavascriptExecutor) driver).executeScript("arguments[0].checked=true;",radio);
								//((JavascriptExecutor) driver).executeScript("arguments[0].onchange()",radio);
					  		}
					  		
					    
					  	
					  	}
					    //14/05/1984
					    
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('tgllhr1')[0].value='14'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('blnhr1')[0].value='05'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('thnhr1')[0].value='1984'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.tgl_lahir1')[0].value='"+tglLahirTT+"'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.lsre_id1')[0].value='7'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.tinggi1')[0].value='168'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.berat1')[0].value='68'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.lsne1')[0].value='1'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.kerja1')[0].value='KARYAWAN'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.lsbs_id_plus1')[0].value='848'");
					    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('ptx.flag_jenis_peserta1')[0].value='0'");
				         
						     
					    
					        
					    
					    
					  	
					  next = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target4']")));
			           next.click();

			           
			           
			           
			           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.mste_flag_cc')[0].value='0'");
			           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('datausulan.mste_flag_cc')[0].onchange()");
			           
			           
			           
			           WebElement caribank1 = (new WebDriverWait(driver,
			          		  10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
			          				 "//*[@name='caribank1']")));
			           caribank1.clear();
			           caribank1.sendKeys("BCA");
			           
			           
			           WebElement btnCari = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='btncari1']")));
			           btnCari.click();
			           
			           Select rekeningBPID = new Select(driver.findElement(By.xpath("//*[@name='rekening_client.lsbp_id']")));
			           
			           rekeningBPID.selectByVisibleText("BCA");
			           
			           
			           WebElement mrccabang = (new WebDriverWait(driver,
				          		  10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				          				 "//*[@name='rekening_client.mrc_cabang']")));
			           mrccabang.clear();
			           mrccabang.sendKeys("JAKARTA");
				           
			           
			    
			           
			           WebElement mrckota = (new WebDriverWait(driver,
				          		  10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				          				 "//*[@name='rekening_client.mrc_kota']")));
			           mrckota.clear();
			           mrckota.sendKeys("JAKARTA");
			          String norek = "1234567891";
					/*
					 * WebElement mrc_no_ac = (new WebDriverWait(driver,
					 * 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					 * "//*[@name='rekening_client.mrc_no_ac']"))); mrc_no_ac.clear();
					 * mrc_no_ac.sendKeys(norek);
					 */
				                 
			           
			           Object String;

			           int cursor = 0;
					for(int j=0;j<12;j++) {
						if(cursor<=norek.length()-1) {
							char c = norek.toCharArray()[j];
							((JavascriptExecutor) driver).executeScript("document.getElementsByName('rekening_client.mrc_no_ac_split["+j+"]')[0].value='"+c+"'");
							cursor++;
						}else {
							((JavascriptExecutor) driver).executeScript("document.getElementsByName('rekening_client.mrc_no_ac_split["+j+"]')[0].value=''");
						}
						
						  ((JavascriptExecutor) driver).executeScript("document.getElementsByName('rekening_client.mrc_no_ac_split["+j+"]')[0].onfocus()");
					
			      };
			      
			      
			      int persen = 100;
			      int numberbisaisi = 0; 
			      ArrayList<Integer> column = new ArrayList<Integer>();
			      for(int d=0;d<=63;d++) {
			    	 // investasiutama.daftarinvestasi[0].mdu_persen1
			    	  
			          WebElement el = (new WebDriverWait(driver,
			          		  5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
			          				 "//*[@name='investasiutama.daftarinvestasi["+d+"].mdu_persen1']")));
			          if(el.getAttribute("readOnly") == null) {
			        	  System.out.println("error");
			        	  numberbisaisi++;
			        	  column.add(d);
			        	  
			        }
			           
			      }
			      
			      if(numberbisaisi>0) {
			    	  System.out.println("add");
			    	  int inputto = 100 - numberbisaisi*10;
			    	  inputto+=10;
			    	  System.out.println(numberbisaisi);
			    	  
			    	  for(Integer ii:column) {
			    		  WebElement el = (new WebDriverWait(driver,
				          		  1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				          				 "//*[@name='investasiutama.daftarinvestasi["+ii+"].mdu_persen1']")));
			    		  if(ii==0) {
			    			  el.sendKeys(Integer.toString(inputto));
			    		  }else {
			    			  el.sendKeys(Integer.toString(10));
					    			  
			    		  }
			    	  }
			      }
                  
			      next = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target5']")));
		           next.click();
			           
		          // next = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target6']")));
		           //next.click();  
		           
		           
		           
		           //next = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Submit »' and @name='_finish']")));
		           //next.click();  
					/*
					 * Alert alert = driver.switchTo().alert(); alert.accept();
					 */
		           
		           //agen.msag_id
		           
		           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('agen.msag_id')[0].value='028070'");
		           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('agen.msag_id')[0].onchange()");
		           
		           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('pemegang.mspo_ao')[0].value='028070'");
		           ((JavascriptExecutor) driver).executeScript("document.getElementsByName('pemegang.mspo_ao')[0].onchange()");
		               
		           try { 
		           Alert alert = driver.switchTo().alert(); alert.accept();
		           alert.accept();
		           }catch(	NoAlertPresentException  e) {
		        	   
		           }
		           
		           next = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Next »' and @name='_target6']")));
		           next.click();  
		           
		           System.out.println("click ya");
		           
			           try {
			        	      //    String actual_msg=driver.findElement(By.id("error")).getText();
			        	          WebDriverWait wait = new WebDriverWait(driver, 2);
			        	          WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("error")));
			        	          System.out.println(el.getText());
			        	      
			        	          }catch(Exception e) {
			        	        	  System.out.println("no error yaa");
			        	          };
                  }
                  
                  next = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Submit »' and @name='_finish']")));
		           next.click(); 
                  
		           
		           
		           try { 
		           Alert alert = driver.switchTo().alert(); alert.accept();
		           alert.accept();
		           }catch(	NoAlertPresentException  e) {
		        	   
		           }
              }
          }
          
          
          Thread.sleep(1000000);
        System.out.println("Selenium Webdriver Script in Internet Explorer browser | Software Testing Material");
        driver.close();
        driver.quit();
        
	}
	
	public static String random() {
		
		return Long.toString(System.currentTimeMillis());
		
	}

}
