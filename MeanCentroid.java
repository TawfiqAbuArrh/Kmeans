package Package;

import static Package.Point.list;
import static Package.kmeans.point;

public class MeanCentroid 
{
    public void newMeanCentroidData()
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
        
        
        AddMeanNewCentroid(0,count1,valueX1,valueY1);
        AddMeanNewCentroid(1,count2,valueX2,valueY2);
        AddMeanNewCentroid(2,count3,valueX3,valueY3);
        AddMeanNewCentroid(3,count4,valueX4,valueY4);
        

    }
    private void AddMeanNewCentroid(int clusterID,int count,double v1,double v2)
    {
        if (count != 0)
            list.set(clusterID, new ClusterCentroid((v1/count),(v2/count)));
        else
            list.set(clusterID, new ClusterCentroid(list.get(clusterID).X(),list.get(clusterID).Y()));
    }
}