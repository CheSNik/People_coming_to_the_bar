public class TheBar {

    /***
     * stores current number of people in the Bar
     */
    private int _numberOfPeopleInBar;

    public TheBar() {}

    /***
     * Use this constructor if there are some number of people in the bar.
     * @param numberOfPeopleInBar initial number of people in the Bar
     */
    public TheBar(int numberOfPeopleInBar) {
        _numberOfPeopleInBar = numberOfPeopleInBar;
    }

    /***
     * Controls whether group of people allowed to come into the bar, and counts people who leave
     * @param numberOfPeopleToGo input number of people tend to come in or go out
     * @return true if entered number of people allowed to come in
     */
    public boolean ControlNumberOfPeople(int numberOfPeopleToGo)
    {
        int tempNumOfPeople = _numberOfPeopleInBar + numberOfPeopleToGo;
        if (tempNumOfPeople > 100)
            return false;
        else
        {
            _numberOfPeopleInBar=tempNumOfPeople;
            return true;
        }
    }

    /***
     * Shows number of people in the bar
     * @return number of people in the bar
     */
    public int GetNumberOfPeople(){
        return _numberOfPeopleInBar;
    }

}
