public class matchUp {
  public int matchUp(int[] nums1, int[] nums2) {
  int counter = 0;
  for (int i = 0; i < nums1.length;i++) {
    if(nums1[i] - nums2[i] == -2) {
      counter ++;
    }
    if(nums1[i] - nums2[i] == -1) {
      counter ++;
    }
    if(nums1[i] - nums2[i] == 2) {
      counter ++;
    }
    if(nums1[i] - nums2[i] == 1) {
      counter ++;
    }
  }
  return counter;
}
}
