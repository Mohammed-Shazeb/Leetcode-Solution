class Solution {
    public double[] internalAngles(int[] sides) {  
        if (sides == null || sides.length < 3) {
            return new double[0];
        }
        
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        
        if (a + b <= c || a + c <= b || b + c <= a) {
            return new double[0];
        }
        
        double cosA = (b * b + c * c - a * a) / (2.0 * b * c);
        double cosB = (a * a + c * c - b * b) / (2.0 * a * c);
        double cosC = (a * a + b * b - c * c) / (2.0 * a * b);
        
        cosA = Math.max(-1.0, Math.min(1.0, cosA));
        cosB = Math.max(-1.0, Math.min(1.0, cosB));
        cosC = Math.max(-1.0, Math.min(1.0, cosC));
        
        double angleA = Math.toDegrees(Math.acos(cosA));
        double angleB = Math.toDegrees(Math.acos(cosB));
        double angleC = Math.toDegrees(Math.acos(cosC));
        
        double[] res = new double[]{angleA, angleB, angleC};
        Arrays.sort(res);
        return res;
    }
}
