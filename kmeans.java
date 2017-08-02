package Package;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class kmeans {
    public static void main(String[] args) {
        try {
            
             /***
            *
            *Tawfiq Abu Arrh
            *
            */
            
            
            //file location "Change it" to your location
        Scanner input = new Scanner(new File("C:\\Users\\Tawfiq\\Desktop\\test_data.txt"));  //Windows
        //Scanner input = new Scanner(new File("/home/tawfiq/Desktop/test_data.txt")); //Linux
        
        
        Scanner in = new Scanner(System.in);
        String answer;
        boolean Exit = true;
        int row = 0,Answer = 0;
        
        //Select Mean OR Median
        System.out.println("Do you want? \n1.Mean\n2.Median");
        while(Exit)
        {
            Answer = in.nextInt();
            if(Answer == 1 ||Answer == 2)
                Exit = false;
            else
                System.out.println("Bad Input,Please Eneter (1,2)");
        }
        
        /*
        *
        *This while loop just for segmant the file and put it in two dimensional 
        *array named "point[][]"
        *
        */
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
        
        /*
        *After finsh it's job
        *Print the two dimensional array after we fill it with data
        */
            for (double[] arr : point) 
                System.out.println(Arrays.toString(arr));
            
                
        //ArrayList to save the centroid to print it after program is finshed
        ArrayList<ClusterCentroid> centroids = new ArrayList();
        
        
        Point pointClass = new Point();
        pointClass.getCentroids();
        pointClass.cluster();
        
        
        boolean continue1 = true;
        while(continue1){
            
            //Added the Cluster centroid in arraylist above
            centroids.add(pointClass.getCentroids(0));
            centroids.add(pointClass.getCentroids(1));
            centroids.add(pointClass.getCentroids(2));
            centroids.add(pointClass.getCentroids(3));
            
            //Ptint the point after this iteration after we cluster it
            for (double[] arr : point) 
                    System.out.println(Arrays.toString(arr));

            System.out.println("Do you want anthor itteration ? (Y/N)");
            answer = in.next();
            
            //If the answer is No Print Centroid that we store in arraylist above
            if (answer.equalsIgnoreCase("N"))
            {
                System.out.println("*******************************************");
                continue1 = false;//to exit from the while loop
                int k =0;
                for (ClusterCentroid object: centroids) {//retrieve data from arraylist above to print it
                    k++;
                    System.out.println("(" + object.X() + " , " + object.Y() + ")");
                    if (k == 4)
                    {
                        System.out.println("*******************************************");
                        k = 0;
                    }
                }
                //Calculate The SSE
                pointClass.SSE();
            }
            
            /*
            *If the answer is Yes ,it will make anthor iteration and calculate new centroid 
            *with Mean OR Median method
            */
            else
            {
                Point SecondPoints = new Point();
                
                //If you select Mean
                if(Answer == 1)
                {
                    MeanCentroid mean = new MeanCentroid();
                    mean.newMeanCentroidData();
                }
                //If you select Median
                else
                {
                    MedianCentroid median = new MedianCentroid();
                    median.newMedianCentroidData();
                }
                
                
                SecondPoints.printNewCentroid();
                
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
        
        point[row][0] = Double.parseDouble((String.valueOf(k)));//insert X value in 1st column
    }
    public static void insertToY(char[] myChar, int i, int countChar,int row)
    {
        char[] k = new char[countChar];
            for(i=i;i<countChar;i++){
                k[i] = myChar[i];
            }

            point[row][1] = Double.parseDouble((String.valueOf(k)));//insert Y value in 2nd column
            
            point [row][2] = Double.parseDouble(String.valueOf(myChar[(myChar.length)-1]));//Insert Cluster value into the 3rd column
    }
}
