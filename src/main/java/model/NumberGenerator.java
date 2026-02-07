package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public BaseballNumber generate(){
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        List<Integer> pick = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pick.add(nums.get(i));
        }
        return new BaseballNumber(pick);
    }
}
