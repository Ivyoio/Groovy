@Grab('commons-net:commons-net:3.6')
import org.apache.commons.net.ftp.FTPClient

void upFile() {
  def ftpClient = new FTPClient()
  String ftpIP = "10.199.63.105"
  String ftpUser = "swinfra\\_PC_AUTO"
  String ftpPwd = "o0plO)PL"
  //String workingFolder = "/test-Ivy/"
  String workingFolder = "/test/"
  //String fileName = "C:\\Jenkins\\Groovy\\Test.txt"
  String fileNameSource = "C:\\Users\\yanzhibi.CORPDOM\\Desktop\\Groovy\\Test-Ivy.txt"
  //String fileNameDesination = "Test.txt"
  String fileNameDesination = "Test-Ivy.txt"
   
  ftpClient.connect(ftpIP)
  ftpClient.enterLocalActiveMode()
  ftpClient.login(ftpUser, ftpPwd)
  println ftpClient.getReplyString()
    
  ftpClient.changeWorkingDirectory(workingFolder)
  fileType = (FTPClient.BINARY_FILE_TYPE)
    
  def upFile = new File(fileNameSource)
  upFile.withInputStream { ostream ->
    ftpClient.storeFile(fileNameDesination, ostream)
  }
  println ftpClient.getReplyString()
    
  ftpClient.disconnect()
}

upFile()
