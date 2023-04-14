import java.util.Arrays;
import java.util.HashMap;
public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2,17,11,15,32};
        int ans[] = sumTargetBest(arr,130);
        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
    // Using Hashmap to solve these in 0(N) times.
    private static int[] sumTargetBest(int[] arr, int target)
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
          int complement = target - arr[i];
          if(map.containsKey(complement))
          {
            return new int[] {map.get(complement),i};
          }
          map.put(arr[i],i);
       }
       return new int[]{-1,-1};
    }
    // Two pointer approach takes O(Log N) times.
    private static int[] sumTargetOptimized(int[] arr, int target)
    {
        int[] ans = new int[2];
        int left = 0;
        int right = arr.length-1;

        int [] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        while(left<right)
        {
            int result = copy[left]+copy[right];
            if(result == target)
                break;
            else if(result<target)
                left++;
            else 
              right--;
        }
        int index1 = -1, index2=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==copy[left] && index1==-1)
            {
                index1 = i;
            }
            else if(arr[i]==copy[right] && index2==-1)
            {
                index2 = i;
            }
        }
        ans[0] = Math.min(index1,index2);
        ans[1] = Math.max(index1,index2);
        return ans;
    }
    // Brute force Approach takes O(n*n) times.
    public static int[] sumTarget(int[] nums, int target)
    {
    int[] ans = new int[2];
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j] == target)
                {
                    ans[k++] = i;
                    ans[k++] = j;
                }
            }
        }
        return ans;
    }
}
