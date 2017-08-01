package Package;

import static Package.Point.list;
import static Package.kmeans.point;
import java.util.ArrayList;

public class MedianCentroid 
{
    public void newMedianCentroidData()
    {
        int count1 =0 , count2 =0 , count3 =0 , count4 =0;
        double X;
        
        
        ArrayList<Double> XAxis1 = new ArrayList();ArrayList<Double> YAxis1 = new ArrayList();
        ArrayList<Double> XAxis2 = new ArrayList();ArrayList<Double> YAxis2 = new ArrayList();
        ArrayList<Double> XAxis3 = new ArrayList();ArrayList<Double> YAxis3 = new ArrayList();
        ArrayList<Double> XAxis4 = new ArrayList();ArrayList<Double> YAxis4 = new ArrayList();

        for(double[] x : point){
            
            X = x[2];

            if (X == 1)
            {
                XAxis1.add(x[0]);
                YAxis1.add(x[1]);
                count1++;
            }
            if (X == 2)
            {
                
                XAxis2.add(x[0]);
                YAxis2.add(x[1]);
                count2++;
            }
            if (X == 3)
            {
                
                XAxis3.add(x[0]);
                YAxis3.add(x[1]);
                count3++;
            }
            if (X == 4)
            {
                
                XAxis4.add(x[0]);
                YAxis4.add(x[1]);
                count4++;
            }
        }
                AddMedianNewCentroid(0,count1,selection_sort(XAxis1),selection_sort(YAxis1));
                AddMedianNewCentroid(1,count2,selection_sort(XAxis2),selection_sort(YAxis2));
                AddMedianNewCentroid(2,count3,selection_sort(XAxis3),selection_sort(YAxis3));
                AddMedianNewCentroid(3,count4,selection_sort(XAxis4),selection_sort(YAxis4));
        
    }            
    private void AddMedianNewCentroid(int ClusterID,int count,double[] SortedX,double[] SortedY)
    {
        if(count != 0)
        {
            count++;
            
            if((count+1) % 2 == 0)
                list.set(ClusterID, new ClusterCentroid(SortedX[(count/2)-1],SortedY[(count/2)-1]));

            else
                {
                    double x = (count/2.0);
                    double CentroidX = ((SortedX[((int)x-1)]+SortedX[((int)x)])/2);
                    double CentroidY = ((SortedY[((int)x-1)]+SortedY[((int)x)])/2);
                    list.set(ClusterID, new ClusterCentroid(CentroidX,CentroidY));
                }
        }
        else
            list.set(ClusterID, new ClusterCentroid(list.get(ClusterID).X(),list.get(ClusterID).Y()));
    }
    private double[] selection_sort(ArrayList<Double> a)
    {
        if(a.size() != 0)
        {
            for (int i = 0; i < a.size() - 1; i++)
                {
                    int index = i;
                    for (int j = i + 1; j < a.size(); j++)
                        if (a.get(j) < a.get(index))
                              index = j;

                    double smallerNumber = a.get(index);

                    a.set(index,a.get(i));
                    a.set(i, smallerNumber);
                }

            double[] d = new double[a.size()];
            for (int i = 0; i < d.length; i++) 
                d[i] = a.get(i);


            return d;
        }
        else
            return null;
    }
}