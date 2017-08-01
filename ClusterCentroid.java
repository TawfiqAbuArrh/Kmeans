package Package;

class ClusterCentroid
    {
            /*Cluster Centroid class that we creat object from it and store it in ArrayList
            *that implemented in Point Class
            */
        private double mX = 0;
        private double mY = 0;
        
        public ClusterCentroid()
        {
            return;
        }
        
        public ClusterCentroid(double x, double y)
        {
            this.X(x);
            this.Y(y);
            return;
        }
        
        public void X(double x)
        {
            this.mX = x;
            return;
        }
        
        public double X()
        {
            return this.mX;
        }
        
        public void Y(double y)
        {
            this.mY = y;
            return;
        }
        
        public double Y()
        {
            return this.mY;
        }
    }