package Package;

import static Package.kmeans.point;
import java.util.ArrayList;
import java.util.Scanner;

public class Point 
{
    //ArrayList that type ClusterCentroid to store X,Y Centroid
    public static ArrayList<ClusterCentroid> list = new ArrayList();
    
    //Arrays to store distances from each point and cluster(1,2,3,4)
    ArrayList<Double> distances1 = new ArrayList();
    ArrayList<Double> distances2 = new ArrayList();
    ArrayList<Double> distances3 = new ArrayList();
    ArrayList<Double> distances4 = new ArrayList();
    Scanner in = new Scanner(System.in);
    
    //To return Centroid of each cluster to main class to store it in arraylist
    public ClusterCentroid getCentroids (int i)
    {
        return list.get(i);
    }
    
    //This method run when program run and take centroid from user
    public void getCentroids()
    {
        System.out.println("Please Choose Centroids for cluster (1,2,3,4) (X , Y): ");
        
        list.add(new ClusterCentroid(in.nextDouble(), in.nextDouble()));
        list.add(new ClusterCentroid(in.nextDouble(), in.nextDouble()));
        list.add(new ClusterCentroid(in.nextDouble(), in.nextDouble()));
        list.add(new ClusterCentroid(in.nextDouble(), in.nextDouble()));
        
        System.out.println("Centroid cluster1 : (" + list.get(0).X() + " , " + list.get(0).Y() + ")");
        System.out.println("Centroid cluster2 : (" + list.get(1).X() + " , " + list.get(1).Y() + ")");
        System.out.println("Centroid cluster3 : (" + list.get(2).X() + " , " + list.get(2).Y() + ")");
        System.out.println("Centroid cluster4 : (" + list.get(3).X() + " , " + list.get(3).Y() + ")");
        
        
        distance(0,list.get(0).X(), list.get(0).Y());
        distance(1,list.get(1).X(), list.get(1).Y());
        distance(2,list.get(2).X(), list.get(2).Y());
        distance(3,list.get(3).X(), list.get(3).Y());
        
    }
    
    /*This method responsible for centroid when user want iteration, what it do
    *that calculate the distance and call distance method that responsible to 
    *store dinstance in arrays "distances(1,2,3,4)" that we creat it above
    */
    public void SecondCentroid()
    {
        distance(0,list.get(0).X(), list.get(0).Y());
        distance(1,list.get(1).X(), list.get(1).Y());
        distance(2,list.get(2).X(), list.get(2).Y());
        distance(3,list.get(3).X(), list.get(3).Y());
    }
    
    public void distance(int cluster,double centroidX,double centroidY)
    {
        double X = 0 , Y = 0;
        for (double[] arr : point) {
            X = (arr[0]-centroidX);
            if(X < 0)
                X*=-1;
            
            Y = (arr[1]-centroidY);
            if(Y < 0)
                Y*=-1;
            
        switch(cluster){
            case 0: distances1.add(X + Y);
            break;
            case 1: distances2.add(X + Y);
            break;
            case 2: distances3.add(X + Y);
            break;
            case 3: distances4.add(X + Y);
            break;
            }
        }
    }
    
    //Cluster Point based in it's distance from each cluster
    public void cluster()
    {
        for(int i = 0; i< distances1.size(); i++)
        {
            double min = distances1.get(i);
            
            if (distances2.get(i) < min){ 
                min = distances2.get(i);
                point[i][2] = 2;
            }
            if(distances3.get(i) < min){
                min = distances3.get(i);
                point[i][2] = 3;
            }
            if(distances4.get(i) < min){
                min = distances4.get(i);
                point[i][2] = 4;
            }
            if (min == distances1.get(i))
                point[i][2] = 1;
        }
    }
    
    //Method for print the new Centroid
    public void printNewCentroid()
    {
        System.out.println("Centroid cluster1 : (" + list.get(0).X() + " , " + list.get(0).Y() + ")");
        System.out.println("Centroid cluster2 : (" + list.get(1).X() + " , " + list.get(1).Y() + ")");
        System.out.println("Centroid cluster3 : (" + list.get(2).X() + " , " + list.get(2).Y() + ")");
        System.out.println("Centroid cluster4 : (" + list.get(3).X() + " , " + list.get(3).Y() + ")");
    }
    
    //Calculate SSE
    public void SSE()
    {
        double sum = 0;
        
        for(int i=0;i<distances1.size();i++)
            sum += Math.pow(distances1.get(0), 2);

        for(int i=0;i<distances2.size();i++)
            sum += Math.pow(distances2.get(0), 2);
            
        for(int i=0;i<distances3.size();i++)
            sum += Math.pow(distances3.get(0), 2);  
           
        for(int i=0;i<distances4.size();i++)
            sum += Math.pow(distances4.get(0), 2);
        
            
        System.out.println("SSE = " + sum);
    }
}