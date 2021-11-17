public class reverse3 {
    public int[] reverse3(int[] nums) {
      int[] fresh = new int[3];
      fresh[0]=nums[2];
      fresh[1]=nums[1];
      fresh[2]=nums[0];
      return fresh;
    }
}
