public class modThree {
  public boolean modThree(int[] nums) {
  for (int i = 0; i < nums.length-2; i++) {
    boolean check = (nums[i] % 2 == 0);
    boolean check1 = (nums[i+1] % 2 == 0);
    boolean check2 = (nums[i+2] % 2 == 0);
    if (check == check1 && check == check2) {
      return true;
    }
  }
  return false;
}
}
