package Package;

import static Package.kmeans.point;
import java.util.ArrayList;
import java.util.Scanner;

public class Point 
{
    static ArrayList<ClusterCentroid> list = new ArrayList();
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
    
    public void newCentroidData()
    {
        int count1 =0 , count2 =0 , count3 =0 , count4 =0;
        double X;
        double valueX1 =0 ,valueY1 = 0;
        double valueX2 =0 ,valueY2 = 0;
        double valueX3 =0 ,valueY3 = 0;
        double valueX4 =0 ,valueY4 = 0;
        
        for (double[] arr : point) {
            X = (arr[2]);

            if (X == 1)
            {   
                count1++;
                valueX1 +=arr[0];
                valueY1 += arr[1];
            }
            else if(X == 2)
            {
                count2++;
                valueX2 +=arr[0];
                valueY2 += arr[1];
            }
            else if(X == 3)
            {
                count3++;
                valueX3 +=arr[0];
                valueY3 += arr[1];
            }
            else if(X == 4)
            {
                count4++;
                valueX4 +=arr[0];
                valueY4 += arr[1];
            }
        }
        
        AddNewCentroid(0,count1,valueX1,valueY1);
        AddNewCentroid(1,count2,valueX2,valueY2);
        AddNewCentroid(2,count3,valueX3,valueY3);
        AddNewCentroid(3,count4,valueX4,valueY4);
        printNewCentroid();

    }
    private void AddNewCentroid(int clusterID,int count,double v1,double v2)
    {
        if (count != 0)
        {
            list.set(clusterID, new ClusterCentroid((v1/count),(v2/count)));
        }
        else
        {
            list.set(clusterID, new ClusterCentroid(list.get(clusterID).X(),list.get(clusterID).Y()));
        }
    }
    private void printNewCentroid()
    {
        System.out.println("Centroid cluster1 : (" + list.get(0).X() + " , " + list.get(0).Y() + ")");
        System.out.println("Centroid cluster2 : (" + list.get(1).X() + " , " + list.get(1).Y() + ")");
        System.out.println("Centroid cluster3 : (" + list.get(2).X() + " , " + list.get(2).Y() + ")");
        System.out.println("Centroid cluster4 : (" + list.get(3).X() + " , " + list.get(3).Y() + ")");
    }
}