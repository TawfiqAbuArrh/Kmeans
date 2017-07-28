package Package;

class ClusterCentroid
    {
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