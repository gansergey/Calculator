package net.gan.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculation implements Parcelable {

    private StringBuilder number1;
    private StringBuilder number2;
    private StringBuilder infoActionOnDisplay;

    private String activeOperation;
    private String lastResult; //Нужно для сохранения данных результата Parcelable

    private int counterOperation;
    private boolean oneNumberOrTwoNumber;

    public Calculation() {
        setDefaultValue();
        clear();
    }

    protected Calculation(Parcel in) {
        activeOperation = in.readString();
        lastResult = in.readString();
    }

    public static final Creator<Calculation> CREATOR = new Creator<Calculation>() {
        @Override
        public Calculation createFromParcel(Parcel in) {
            return new Calculation(in);
        }

        @Override
        public Calculation[] newArray(int size) {
            return new Calculation[size];
        }
    };

    public void numberClick(String number) {
        counterOperation = 0;
        if (oneNumberOrTwoNumber) {
            number1.append(number);
        } else {
            number2.append(number);
        }
        infoActionOnDisplay.append(number);
    }

    public void operationClick(String operation) {
        if (number1.length() > 0) {
            oneNumberOrTwoNumber = false;
            if (counterOperation == 0) {
                counterOperation++;
                activeOperation = operation;
                infoActionOnDisplay.append(operation);
            }
        }
    }

    public String getInfo() {
        if (infoActionOnDisplay.length() == 0) {
            return lastResult;
        } else {
            return infoActionOnDisplay.toString();
        }
    }

    public void calculateResult() {
        float result;
        if (number1.length() > 0 && number2.length() > 0 && activeOperation.length() > 0) {
            switch (activeOperation) {
                case ("/"):
                    result = Float.parseFloat(number1.toString()) / Float.parseFloat(number2.toString());
                    break;
                case "*":
                    result = Float.parseFloat(number1.toString()) * Float.parseFloat(number2.toString());
                    break;
                case "+":
                    result = Float.parseFloat(number1.toString()) + Float.parseFloat(number2.toString());
                    break;
                case "-":
                    result = Float.parseFloat(number1.toString()) - Float.parseFloat(number2.toString());
                    break;
                default:
                    result = 0;
                    break;
            }
            infoActionOnDisplay.append("= \n");
            infoActionOnDisplay.append(result);
            lastResult = infoActionOnDisplay.toString();
        }
        clear();
    }

    public void clear() {
        number1 = new StringBuilder();
        number2 = new StringBuilder();
        infoActionOnDisplay = new StringBuilder();
        oneNumberOrTwoNumber = true;
        counterOperation  = 0;
        activeOperation = "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(activeOperation);
        dest.writeString(lastResult);
    }

    public void setDefaultValue() {
        lastResult = "0";
    }
}