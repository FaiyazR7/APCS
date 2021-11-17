public class no14 {
  public boolean no14(int[] nums) {
  int one = 0;
  int four = 0;
  for (int i = 0; i < nums.length; i++) {
    if (nums[i] == 1) {
      one = 1;
    }
    if (nums[i] == 4) {
      four = 1;
    }
  }
  return !(one == 1 && four == 1);
}

}
