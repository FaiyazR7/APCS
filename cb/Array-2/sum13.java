public class sum13 {
  public int sum13(int[] nums) {
  int sum = 0;
  for (int i = 0; i < nums.length; i ++) {
    if (nums[i] == 13) {
      i+=1;
    }
    else {
      sum+=nums[i];
  }
  }
  return sum;
}

}
