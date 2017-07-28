package Package;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class kmeans {
    public static void main(String[] args) {
        try {
            
        //File Location , As you like just copy file location and paste it in directory below.
            
        Scanner input = new Scanner(new File("/home/###NAME###/Desktop/test_data.txt"));Linux
        //Scanner input = new Scanner(new File("C:\\Usres\\###NAME###\\Desktop\\test_data.txt"));Windows
            
            
        Scanner in = new Scanner(System.in);
        String answer;
        
        int row = 0;
        
            
        while (input.hasNextLine()) {
            int countChar = 0;
            String line = input.nextLine();
            char[] myChar = line.toCharArray();
            for (int i=0;i<myChar.length;i++){

                if (myChar[countChar] == ',')
                {
                    insertToX(myChar,0,countChar,row);
                    
                    insertToY(myChar,(countChar+1),(myChar.length-2),row);
                    
                    i = 100;//to go the next line
                }
                else
                    countChar++;
            }
            row++;
        }
            for (double[] arr : point) {
                System.out.println(Arrays.toString(arr));
            }
                
        ArrayList<ClusterCentroid> centroids = new ArrayList();
        Point pointClass = new Point();
        pointClass.getCentroids();
        pointClass.cluster();
        
        boolean continue1 = true;
        while(continue1){

            centroids.add(pointClass.getCentroids(0));
            centroids.add(pointClass.getCentroids(1));
            centroids.add(pointClass.getCentroids(2));
            centroids.add(pointClass.getCentroids(3));

            for (double[] arr : point) {
                    System.out.println(Arrays.toString(arr));
                }

            System.out.println("Do you want anthor itteration ? (Y/N)");
            answer = in.next();

            if (answer.equalsIgnoreCase("N"))
            {
                System.out.println("*******************************************");
                continue1 = false;int k =0;
                for (ClusterCentroid object: centroids) {
                    k++;
                    System.out.println("(" + object.X() + " , " + object.Y() + ")");
                    if (k == 4)
                    {
                        System.out.println("*******************************************");
                        k = 0;
                    }
                }
            }
            else
            {
                Point SecondPoints = new Point();
                
                SecondPoints.newCentroidData();
                
                SecondPoints.SecondCentroid();
                
                SecondPoints.cluster();
            }
        }
                
        }catch(Exception ex) {System.err.println("Error in loading file");}
        
    }
    
    public static double[][] point = new double[863][3];
    public static void insertToX(char[] myChar, int i, int countChar,int row)
    {
        char[] k = new char[countChar];
        for(i=i;i<countChar;i++)
            k[i] = myChar[i];
        
        point[row][0] = Double.parseDouble((String.valueOf(k)));
    }
    public static void insertToY(char[] myChar, int i, int countChar,int row)
    {
        char[] k = new char[countChar];
            for(i=i;i<countChar;i++){
                k[i] = myChar[i];
            }

            point[row][1] = Double.parseDouble((String.valueOf(k)));
            point [row][2] = Double.parseDouble(String.valueOf(myChar[(myChar.length)-1]));
    }
}
