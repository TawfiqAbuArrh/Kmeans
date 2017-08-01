package Package;

import static Package.kmeans.point;
import java.util.ArrayList;
import java.util.Scanner;

public class Point 
{
    public static ArrayList<ClusterCentroid> list = new ArrayList();
    ArrayList<Double> distances1 = new ArrayList();
    ArrayList<Double> distances2 = new ArrayList();
    ArrayList<Double> distances3 = new ArrayList();
    ArrayList<Double> distances4 = new ArrayList();
    Scanner in = new Scanner(System.in);
    
    public ClusterCentroid getCentroids (int i)
    {
        return list.get(i);
    }
    
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
    
    public void printNewCentroid()
    {
        System.out.println("Centroid cluster1 : (" + list.get(0).X() + " , " + list.get(0).Y() + ")");
        System.out.println("Centroid cluster2 : (" + list.get(1).X() + " , " + list.get(1).Y() + ")");
        System.out.println("Centroid cluster3 : (" + list.get(2).X() + " , " + list.get(2).Y() + ")");
        System.out.println("Centroid cluster4 : (" + list.get(3).X() + " , " + list.get(3).Y() + ")");
    }
    
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