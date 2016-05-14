
package crypttechniques;

import java.util.Arrays;

/**
 *KEY VALUE VE KEYWORDLERI DEGISTIREREK YENI DURUMLAR DENENEBILIR
 * @author FurkanAkharman
 */
public class EncryptionAlgorithms {
    private final  char[] array;
    private final  char[] array2;
   
    
    public EncryptionAlgorithms(String incoming){//constructorumuz orijinal metni cagilirilrken almali
      System.out.println("INCOMING STRING: "+incoming);
        int length=incoming.length();
         System.out.println("LENGTH "+length);
     array2=new char[length];
             //System.out.println("Array2in 1-2 elemani "+array2[0]+array2[1]);
    //array = new char[length];
    array=incoming.toCharArray();
   //  System.out.println("Arrayin 1-2 elemani "+array[0]+array[1]);
     
    }
    
    
    public String caeserAlgorithm(){
    String encryptedText;
    int keyValue=7;
      // int i;
       for(int i=0;i<array.length;i++){
         //  System.out.println(i+"->"+array[i]);
           int originalCharacter=(int)array[i];
       array2[i]=(char) ((originalCharacter+keyValue)%256);
          
       
       }
   encryptedText=Arrays.toString(array2);
           
   return encryptedText;
    }
    
    //
    public String vigenereAlgorithm(){
   
        String encryptedText;
    String keyWord="merhaba";
    char[] keywordArray=new char[array.length];
    int j=0;
    while(keyWord.length()<array.length){
    keyWord=keyWord.concat(keyWord);}
        for (int i = 0; i < array.length; i++) {
            keywordArray[i] = keyWord.charAt(i);
                    }
        System.out.println(Arrays.toString(keywordArray));
        for (int i = 0; i < array.length; i++) {
            int originalCharacter = (int) array[i];
            array2[i] = (char) ((originalCharacter + keywordArray[i]));

        }
     encryptedText=Arrays.toString(array2);
    return encryptedText;
    }
    //
    public String rsa(){
    String encryptedText;
    //Sifrelemede kullanilacak asal sayilar
    int P=13;
    int Q=7;
int N=P*Q;
int fiN=(P-1)*(Q-1);
int E=2; //E miz asagidaki islemden sonra random olmadi 1den büyük finden kücük ve relatively prime minimum number oldu
while(E<fiN&&greatestCommonDivider(E, fiN)!=1){E=E+1;}
        System.out.println("E nin degeri: "+E+" Nnin ve fiN in degeri: "+N+"/"+fiN);

        for(int i=0;i<array.length;i++){
        int originalCharacter =(int) array[i];
        array2[i]=(char)((Math.pow(originalCharacter, E))%N);
                
                }
    
    
    //******
    encryptedText=Arrays.toString(array2);
    return encryptedText;
    }
    
    
    private int greatestCommonDivider(int num1,int num2){
    int temp;
    while(num2!=0){
    temp=num1;
    num1=num2;
    num2=temp%num2;
    }
    return num1;//en büyük ortak bölenimiz 1 cikarsa aralarinda asal demektir
    }
    
    
    
    //end of class
}
