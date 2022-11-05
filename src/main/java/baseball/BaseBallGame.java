package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseBallGame {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();
    private List<Integer> strikeAndBall = new ArrayList<>();

    public List<Integer> randomNumbers() {
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (computer.contains(randomNum) == false) {
                computer.add(randomNum);
            }
        }
        System.out.println("computer숫자"+computer);
        return computer;
    }

    public List<Integer> inputNumbers() throws IllegalStateException {
        String inputNum = Console.readLine();
        String[] nums = inputNum.split("");

        if (nums.length != 3) {
            throw new IllegalStateException();
        }
        for (String num : nums) {
            int numInt = Integer.parseInt(num);
            if (user.contains(numInt)) {
                throw new IllegalStateException();
            } else {
                user.add(numInt);
            }
        }
        return user;
    }

    public List<Integer> findNumber(List<Integer> computer, List<Integer> user){
        int strike = 0;
        int ball = 0;

        for(int i=0; i<computer.size(); i++){
            if(computer.get(i) == user.get(i)){
                strike ++;
            }else if(computer.contains(user.get(i))){
                ball ++;
            }
        }
        strikeAndBall.add(strike);
        strikeAndBall.add(ball);
        return strikeAndBall;
    }

}