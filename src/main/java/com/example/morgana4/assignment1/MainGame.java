package com.example.morgana4.assignment1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.morgana4.assignment1.R.id.b1;
import static com.example.morgana4.assignment1.R.id.sA;


public class MainGame extends AppCompatActivity {
    //INSTANCE VARIABLES
    Button buttonsList[];
    Button switchesList[];
    int colorsList[];
    int number;
    boolean solved;
    TextView sequence;
    TextView counter;
    public Button sA, sB, sC, sD, sE, sF, sG, sH, sI, sJ;

    //**********CONSTRUCTOR**********//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        number = 0;
        solved = false;
        buttonsList = new Button[16];
        colorsList = new int[16];
        switchesList = new Button[10];
        sequence = (TextView) findViewById(R.id.sequence);
        sequence.setText("Sequence: ");
        counter = (TextView) findViewById(R.id.counter);

        Button b0 = (Button) findViewById(R.id.b0);
        buttonsList[0] = b0;
        Button b1 = (Button) findViewById(R.id.b1);
        buttonsList[1] = b1;
        Button b2 = (Button) findViewById(R.id.b2);
        buttonsList[2] = b2;
        Button b3 = (Button) findViewById(R.id.b3);
        buttonsList[3] = b3;
        Button b4 = (Button) findViewById(R.id.b4);
        buttonsList[4] = b4;
        Button b5 = (Button) findViewById(R.id.b5);
        buttonsList[5] = b5;
        Button b6 = (Button) findViewById(R.id.b6);
        buttonsList[6] = b6;
        Button b7 = (Button) findViewById(R.id.b7);
        buttonsList[7] = b7;
        Button b8 = (Button) findViewById(R.id.b8);
        buttonsList[8] = b8;
        Button b9 = (Button) findViewById(R.id.b9);
        buttonsList[9] = b9;
        Button b10 = (Button) findViewById(R.id.b10);
        buttonsList[10] = b10;
        Button b11 = (Button) findViewById(R.id.b11);
        buttonsList[11] = b11;
        Button b12 = (Button) findViewById(R.id.b12);
        buttonsList[12] = b12;
        Button b13 = (Button) findViewById(R.id.b13);
        buttonsList[13] = b13;
        Button b14 = (Button) findViewById(R.id.b14);
        buttonsList[14] = b14;
        Button b15 = (Button) findViewById(R.id.b15);
        buttonsList[15] = b15;

        sA = (Button) findViewById(R.id.sA);
        switchesList[0] = sA;
        sB = (Button) findViewById(R.id.sB);
        switchesList[1] = sB;
        sC = (Button) findViewById(R.id.sC);
        switchesList[2] = sC;
        sD = (Button) findViewById(R.id.sD);
        switchesList[3] = sD;
        sE = (Button) findViewById(R.id.sE);
        switchesList[4] = sE;
        sF = (Button) findViewById(R.id.sF);
        switchesList[5] = sF;
        sG = (Button) findViewById(R.id.sG);
        switchesList[6] = sG;
        sH = (Button) findViewById(R.id.sH);
        switchesList[7] = sH;
        sI = (Button) findViewById(R.id.sI);
        switchesList[8] = sI;
        sJ = (Button) findViewById(R.id.sJ);
        switchesList[9] = sJ;

//RADOMIZE BOARD ON STARTUP
        for (int j = 0; j < buttonsList.length; j++) {
            Random r = new Random();
            int i = r.nextInt(2);
            if (i == 0 || i == 2) {
                buttonsList[j].setBackgroundColor(Color.WHITE);
                colorsList[j] = 2;
            } else {
                buttonsList[j].setBackgroundColor(Color.BLACK);
                colorsList[j] = 1;
            }
        }

        isSolved();
    }

    //**********TEXTVIEW UPDATE METHODS**********//
    public void autoSolve(View v) {
//        Log.v("TAG", "autoSolve is called");
        if (isSolved() == true) {
            counter.setText("Move Count: 0");
            sequence.setText("Sequence: is already solved!");
        } else {
            testBut1();
            if (isSolved()) {
                return;
            }
            testBut2();
            if (isSolved()) {
                return;
            }
            testBut3();
            if (isSolved()) {
                return;
            }
            testBut4();
            if (isSolved()) {
                return;
            }
            testBut5();
            if (isSolved()) {
                return;
            }
            testBut6();
            if (isSolved()) {
                return;
            }
            testBut7();
            if (isSolved()) {
                return;
            }
            testBut8();
            if (isSolved()) {
                return;
            }
            testBut10();
            if (isSolved()) {
                return;
            } else {
                Toast.makeText(this, "No Solution",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void updateSequence(View v, String tag) {
//        Log.v("TAG", "sequence is called");
        sequence.setText(sequence.getText() + tag);
    }

    public void updateCounter(View v) {
//        Log.v("TAG", "updateCounter is called");
        counter.setText("Switches Pressed: " + number);
    }

    public void restartGame(View v) {
//        Log.v("TAG", "restartGame is called");
        for (int j = 0; j < buttonsList.length; j++) {
            Random r = new Random();
            int i = r.nextInt(2);
            if (i == 0 || i == 2) {
                buttonsList[j].setBackgroundColor(Color.WHITE);
                colorsList[j] = 2;
            } else {
                buttonsList[j].setBackgroundColor(Color.BLACK);
                colorsList[j] = 1;
            }
        }
        isSolved();
        number = 0;
        updateCounter(v);
        sequence.setText("Sequence: ");
        solved = false;
    }


    //**********HELPER METHODS**********//
    public String getTag(Button b) {
        String tag = b.getTag().toString();
        return tag;
    }

    public boolean isSolved() {
        if (colorsList[0] == 1) {
            for (int i = 0; i < colorsList.length; i++) {
                if (colorsList[i] == 1) {
                    solved = true;
                } else {
                    solved = false;
                    return false;
                }
            }
        } else if (colorsList[0] == 2) {
            for (int i = 0; i < colorsList.length; i++) {
                if (colorsList[i] == 2) {
                    solved = true;
                } else {
                    return false;
                }
            }
        }
        if (solved = true) {
//            Toast.makeText(this, "CONGRATS! YOU WON!",
//                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return solved;
    }


    public void swapColors(int arrayEntry) {
        if (colorsList[arrayEntry] == 2) {
            buttonsList[arrayEntry].setBackgroundColor(Color.BLACK);
            colorsList[arrayEntry] = 1;
        } else if (colorsList[arrayEntry] == 1) {
            buttonsList[arrayEntry].setBackgroundColor(Color.WHITE);
            colorsList[arrayEntry] = 2;
        }
    }

    //**********SINGLE SWAP METHODS**********//
    public void switch0(View v) {
     //   Log.v("TAG", "sA is called");
        swapColors(0);
        isSolved();
    }
    public void switch1(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(1);
    }
    public void switch2(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(2);
        isSolved();
    }
    public void switch3(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(3);
        isSolved();
    }
    public void switch4(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(4);
        isSolved();
    }
    public void switch5(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(5);
        isSolved();
    }
    public void switch6(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(6);
        isSolved();
    }
    public void switch7(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(7);
        isSolved();
    }
    public void switch8(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(8);
        isSolved();
    }
    public void switch9(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(9);
        isSolved();
    }
    public void switch10(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(10);
        isSolved();
    }
    public void switch11(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(11);
        isSolved();
    }
    public void switch12(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(12);
        isSolved();
    }
    public void switch13(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(13);
        isSolved();
    }
    public void switch14(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(14);
        isSolved();
    }
    public void switch15(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(15);
        isSolved();
    }

    //**********SWTICH METHODS**********//


    public void switchA(View v) {
//        Log.v("TAG", "sA is called");
        swapColors(0);
        swapColors(1);
        swapColors(2);
        number++;
        updateCounter(v);
        String tag = getTag(sA);
        updateSequence(v, tag);
        isSolved();
    }

    public void switchB(View v) {
//        Log.v("TAG", "sB is called");
        swapColors(3);
        swapColors(7);
        swapColors(9);
        swapColors(11);
        number++;
        isSolved();
        updateCounter(v);
        String tag = getTag(sB);
        updateSequence(v, tag);
    }

    public void switchC(View v) {
//        Log.v("TAG", "sC is called");
        swapColors(4);
        swapColors(10);
        swapColors(14);
        swapColors(15);
        number++;
        isSolved();
        updateCounter(v);
        String tag = getTag(sC);
        updateSequence(v, tag);
    }

    public void switchD(View v) {
//        Log.v("TAG", "sD is called");
        swapColors(0);
        swapColors(4);
        swapColors(5);
        swapColors(6);
        swapColors(7);
        isSolved();
        number++;
        updateCounter(v);
        String tag = getTag(sD);
        updateSequence(v, tag);
    }

    public void switchE(View v) {
//        Log.v("TAG", "sE is called");
        swapColors(6);
        swapColors(7);
        swapColors(8);
        swapColors(10);
        swapColors(12);
        isSolved();
        number++;
        updateCounter(v);
        String tag = getTag(sE);
        updateSequence(v, tag);
    }

    public void switchF(View v) {
//        Log.v("TAG", "sF is called");
        swapColors(0);
        swapColors(2);
        swapColors(14);
        swapColors(15);
        isSolved();
        number++;
        updateCounter(v);
        String tag = getTag(sF);
        updateSequence(v, tag);
    }

    public void switchG(View v) {
//        Log.v("TAG", "sG is called");
        swapColors(3);
        swapColors(14);
        swapColors(15);
        number++;
        isSolved();
        updateCounter(v);
        String tag = getTag(sG);
        updateSequence(v, tag);
    }

    public void switchH(View v) {
//        Log.v("TAG", "sH is called");
        swapColors(4);
        swapColors(5);
        swapColors(7);
        swapColors(14);
        swapColors(15);
        number++;
        isSolved();
        updateCounter(v);
        String tag = getTag(sH);
        updateSequence(v, tag);
    }

    public void switchI(View v) {
//        Log.v("TAG", "sI is called");
        swapColors(1);
        swapColors(2);
        swapColors(3);
        swapColors(4);
        swapColors(5);
        number++;
        isSolved();
        updateCounter(v);
        String tag = getTag(sI);
        updateSequence(v, tag);
    }

    public void switchJ(View v) {
//        Log.v("TAG", "sJ is called");
        swapColors(3);
        swapColors(4);
        swapColors(5);
        swapColors(9);
        swapColors(13);
        number++;
        isSolved();
        updateCounter(v);
        String tag = getTag(sJ);
        updateSequence(v, tag);
    }

//**********AUTOSOLVE TESTS**********//
    public void testBut1() {
        for (int i = 0; i < switchesList.length; i++) {
            Button iv = switchesList[i];
            iv.performClick();
            if (isSolved() == true) {
                counter.setText("Moves Pressed: 1");
                String tag = getTag(iv);
                sequence.setText("Sequence: " + tag);
                return;
            } else {
                iv.performClick();
                solved = false;
            }
        }
    }

    public void testBut2() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                Button vi = switchesList[i];
                Button vj = switchesList[j];
                vi.performClick();
                vj.performClick();
                if (isSolved() == true) {
                    counter.setText("Moves Pressed: 2");
                    String tag = getTag(vi) + getTag(vj);
                    sequence.setText("Sequence: " + tag);
                    return;
                } else {
                    solved = false;
                    vi.performClick();
                    vj.performClick();
                }
            }
        }
    }

    public void testBut3(){
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    Button vi = switchesList[i];
                    Button vj = switchesList[j];
                    Button vk = switchesList[k];
                    vi.performClick();
                    vj.performClick();
                    vk.performClick();
                    if (isSolved() == true) {
                        counter.setText("Moves Pressed: 3");
                        String tag = getTag(vi) + getTag(vj) + getTag(vk);
                        sequence.setText("Sequence: " + tag);
                        return;
                    } else {
                        solved = false;
                        vi.performClick();
                        vj.performClick();
                        vk.performClick();
                    }
                }
            }
        }
    }

    public void testBut4() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    for (int l = k; l < switchesList.length; l++) {
                        Button vi = switchesList[i];
                        Button vj = switchesList[j];
                        Button vk = switchesList[k];
                        Button vl = switchesList[l];
                        vi.performClick();
                        vj.performClick();
                        vk.performClick();
                        vl.performClick();
                        if (isSolved() == true) {
                            counter.setText("Moves Pressed: 4");
                            String tag = getTag(vi) + getTag(vj) + getTag(vk) + getTag(vl);
                            sequence.setText("Sequence: " + tag);
                            return;
                        } else {
                            solved = false;
                            vi.performClick();
                            vj.performClick();
                            vk.performClick();
                            vl.performClick();
                        }
                    }
                }
            }
        }
    }

    public void testBut5() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    for (int l = k; l < switchesList.length; l++) {
                        for (int m = k; m < switchesList.length; m++) {
                            Button vi = switchesList[i];
                            Button vj = switchesList[j];
                            Button vk = switchesList[k];
                            Button vl = switchesList[l];
                            Button vm = switchesList[m];
                            vi.performClick();
                            vj.performClick();
                            vk.performClick();
                            vl.performClick();
                            vm.performClick();
                            if (isSolved() == true) {
                                counter.setText("Moves Pressed: 5");
                                String tag = getTag(vi) + getTag(vj) + getTag(vk) + getTag(vl) + getTag(vm);
                                sequence.setText("Sequence: " + tag);
                                return;
                            } else {
                                solved = false;
                                vi.performClick();
                                vj.performClick();
                                vk.performClick();
                                vl.performClick();
                                vm.performClick();
                            }
                        }
                    }
                }
            }
        }
    }

    public void testBut6() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    for (int l = k; l < switchesList.length; l++) {
                        for (int m = k; m < switchesList.length; m++) {
                            for (int n = m; n < switchesList.length; n++) {
                                Button vi = switchesList[i];
                                Button vj = switchesList[j];
                                Button vk = switchesList[k];
                                Button vl = switchesList[l];
                                Button vm = switchesList[m];
                                Button vn = switchesList[n];
                                vi.performClick();
                                vj.performClick();
                                vk.performClick();
                                vl.performClick();
                                vm.performClick();
                                vn.performClick();
                                if (isSolved() == true) {
                                    counter.setText("Moves Pressed: 6");
                                    String tag = getTag(vi) + getTag(vj) + getTag(vk) + getTag(vl) + getTag(vm) + getTag(vn);
                                    sequence.setText("Sequence: " + tag);
                                    return;
                                } else {
                                    solved = false;
                                    vi.performClick();
                                    vj.performClick();
                                    vk.performClick();
                                    vl.performClick();
                                    vm.performClick();
                                    vn.performClick();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void testBut7() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    for (int l = k; l < switchesList.length; l++) {
                        for (int m = k; m < switchesList.length; m++) {
                            for (int n = m; n < switchesList.length; n++) {
                                for (int o = n; o < switchesList.length; o++) {
                                    Button vi = switchesList[i];
                                    Button vj = switchesList[j];
                                    Button vk = switchesList[k];
                                    Button vl = switchesList[l];
                                    Button vm = switchesList[m];
                                    Button vn = switchesList[n];
                                    Button vo = switchesList[o];
                                    vi.performClick();
                                    vj.performClick();
                                    vk.performClick();
                                    vl.performClick();
                                    vm.performClick();
                                    vn.performClick();
                                    vo.performClick();
                                    if (isSolved() == true) {
                                        counter.setText("Moves Pressed: 7");
                                        String tag = getTag(vi) + getTag(vj) + getTag(vk) + getTag(vl) + getTag(vm) + getTag(vn) + getTag(vo);
                                        sequence.setText("Sequence: " + tag);
                                        return;
                                    } else {
                                        solved = false;
                                        vi.performClick();
                                        vj.performClick();
                                        vk.performClick();
                                        vl.performClick();
                                        vm.performClick();
                                        vn.performClick();
                                        vo.performClick();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void testBut8() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    for (int l = k; l < switchesList.length; l++) {
                        for (int m = k; m < switchesList.length; m++) {
                            for (int n = m; n < switchesList.length; n++) {
                                for (int o = n; o < switchesList.length; o++) {
                                    for (int p = o; p < switchesList.length; o++) {
                                        Button vi = switchesList[i];
                                        Button vj = switchesList[j];
                                        Button vk = switchesList[k];
                                        Button vl = switchesList[l];
                                        Button vm = switchesList[m];
                                        Button vn = switchesList[n];
                                        Button vo = switchesList[o];
                                        Button vp = switchesList[p];
                                        vi.performClick();
                                        vj.performClick();
                                        vk.performClick();
                                        vl.performClick();
                                        vm.performClick();
                                        vn.performClick();
                                        vo.performClick();
                                        vp.performClick();
                                        if (isSolved() == true) {
                                            counter.setText("Moves Pressed: 8");
                                            String tag = getTag(vi) + getTag(vj) + getTag(vk) +
                                                    getTag(vl) + getTag(vm) + getTag(vn) +
                                                    getTag(vo) + getTag(vp);
                                            sequence.setText("Sequence: " + tag);
                                            return;
                                        } else {
                                            solved = false;
                                            vi.performClick();
                                            vj.performClick();
                                            vk.performClick();
                                            vl.performClick();
                                            vm.performClick();
                                            vn.performClick();
                                            vo.performClick();
                                            vp.performClick();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void testBut9() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    for (int l = k; l < switchesList.length; l++) {
                        for (int m = k; m < switchesList.length; m++) {
                            for (int n = m; n < switchesList.length; n++) {
                                for (int o = n; o < switchesList.length; o++) {
                                    for (int p = o; p < switchesList.length; p++) {
                                        for (int q = p; q < switchesList.length; q++) {
                                            Button vi = switchesList[i];
                                            Button vj = switchesList[j];
                                            Button vk = switchesList[k];
                                            Button vl = switchesList[l];
                                            Button vm = switchesList[m];
                                            Button vn = switchesList[n];
                                            Button vo = switchesList[o];
                                            Button vp = switchesList[p];
                                            Button vq = switchesList[q];
                                            vi.performClick();
                                            vj.performClick();
                                            vk.performClick();
                                            vl.performClick();
                                            vm.performClick();
                                            vn.performClick();
                                            vo.performClick();
                                            vp.performClick();
                                            vq.performClick();
                                            if (isSolved() == true) {
                                                counter.setText("Moves Pressed: 9");
                                                String tag = getTag(vi) + getTag(vj) + getTag(vk) +
                                                        getTag(vl) + getTag(vm) + getTag(vn) +
                                                        getTag(vo) + getTag(vp) + getTag(vq);
                                                sequence.setText("Sequence: " + tag);
                                                return;
                                            } else {
                                                solved = false;
                                                vi.performClick();
                                                vj.performClick();
                                                vk.performClick();
                                                vl.performClick();
                                                vm.performClick();
                                                vn.performClick();
                                                vo.performClick();
                                                vp.performClick();
                                                vq.performClick();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void testBut10() {
        for (int i = 0; i < switchesList.length; i++) {
            for (int j = i; j < switchesList.length; j++) {
                for (int k = j; k < switchesList.length; k++) {
                    for (int l = k; l < switchesList.length; l++) {
                        for (int m = k; m < switchesList.length; m++) {
                            for (int n = m; n < switchesList.length; n++) {
                                for (int o = n; o < switchesList.length; o++) {
                                    for (int p = o; p < switchesList.length; p++) {
                                        for (int q = p; q < switchesList.length; q++) {
                                            for (int r = q; r < switchesList.length; r++) {
                                                Button vi = switchesList[i];
                                                Button vj = switchesList[j];
                                                Button vk = switchesList[k];
                                                Button vl = switchesList[l];
                                                Button vm = switchesList[m];
                                                Button vn = switchesList[n];
                                                Button vo = switchesList[o];
                                                Button vp = switchesList[p];
                                                Button vq = switchesList[q];
                                                Button vr = switchesList[r];
                                                vi.performClick();
                                                vj.performClick();
                                                vk.performClick();
                                                vl.performClick();
                                                vm.performClick();
                                                vn.performClick();
                                                vo.performClick();
                                                vp.performClick();
                                                vq.performClick();
                                                vr.performClick();
                                                if (isSolved() == true) {
                                                    counter.setText("Moves Pressed: 10 (MAX)");
                                                    String tag = getTag(vi) + getTag(vj) + getTag(vk) +
                                                            getTag(vl) + getTag(vm) + getTag(vn) +
                                                            getTag(vo) + getTag(vp) + getTag(vq) +
                                                            getTag(vr);
                                                    sequence.setText("Sequence: " + tag);
                                                    return;
                                                } else {
                                                    solved = false;
                                                    vi.performClick();
                                                    vj.performClick();
                                                    vk.performClick();
                                                    vl.performClick();
                                                    vm.performClick();
                                                    vn.performClick();
                                                    vo.performClick();
                                                    vp.performClick();
                                                    vq.performClick();
                                                    vr.performClick();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    }

