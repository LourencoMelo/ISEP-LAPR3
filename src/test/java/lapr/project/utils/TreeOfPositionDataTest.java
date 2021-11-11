package lapr.project.utils;

import lapr.project.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TreeOfPositionDataTest {

    /**
     * Objects for Testing
     */

    Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

    /**
     * Objects For atLeastTwo()
     */
    LocalDateTime mainDateTest1 = LocalDateTime.of(2020, 12,29,17,19);
    LocalDateTime mainDateTest2 = LocalDateTime.of(2020, 12,31,17,19);
    LocalDateTime secondaryDateTest1 = LocalDateTime.of(2020, 12,30,17,19);

    /**
     * Objects For MeanSog()
     */
    LocalDateTime mainSogDate1 = LocalDateTime.of(2020, 12,30,17,19);
    LocalDateTime mainSogDate2 = LocalDateTime.of(2020, 12,30,18,29);
    LocalDateTime mainSogDate3 = LocalDateTime.of(2020, 12,30,19,19);

    /**
     * Objects For TravelDistance Tests
     */

    LocalDateTime dateTravelDistance1 = LocalDateTime.of(2020, 12,30,17,19);
    LocalDateTime dateTravelDistance2 = LocalDateTime.of(2020, 12,30,18,29);
    LocalDateTime dateTravelDistance3 = LocalDateTime.of(2020, 12,30,19,19);


    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  DISTANCE TESTS
     *
     * ---------------------------------------------------------------------------------------
     */

    @Test
    void distance() {
        double expected = 4.369711529939779;
        double result = Distance.distance(28.37458,-88.88584,28.35085,-88.85024);

        assertEquals(expected,result);
    }

    @Test
    void distance2() {
        double expected = 0;
        double result = Distance.distance(28.37458,-88.88584,28.37458,-88.88584);

        assertEquals(expected,result);
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  AT LEAST TWO TESTS
     *
     * ---------------------------------------------------------------------------------------
     */


    @Test
    void atLeastTwo(){
        /**
         * Position Data
         */
        PositionData positionDataTestCompare1 = new PositionData(mainDateTest1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(secondaryDateTest1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainDateTest2,10,10,3,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(true, shipTestCompare1.atLeastTwo(mainDateTest1,mainDateTest2));
    }

    @Test
    void atLeastTwoFalse1Position(){

        /**
         * Position Data
         */
        PositionData positionDataTestCompare1 = new PositionData(mainDateTest1,10,10,3,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);


        assertEquals(false, shipTestCompare1.atLeastTwo(mainDateTest1,mainDateTest2));
    }

    @Test
    void atLeastTwoFalse0Positions(){

        assertEquals(false, shipTestCompare1.atLeastTwo(mainDateTest1,mainDateTest2));
    }

    @Test
    void atLeastTwoFalsePositionsNotInLimits(){
        /**
         * Parameters Created
         */
        LocalDateTime dateTest1 = LocalDateTime.of(2020, 12,24,17,19);
        LocalDateTime dateTest2 = LocalDateTime.of(2020, 12,26,17,19);

        /**
         * Position Data
         */
        LocalDateTime date = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime date1 = LocalDateTime.of(2020, 12,31,17,19);

        PositionData positionDataTestCompare1 = new PositionData(dateTest1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(date,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(date1,10,10,3,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(false, shipTestCompare1.atLeastTwo(dateTest1,dateTest2));
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  MEAN SOG TESTS
     *
     * ---------------------------------------------------------------------------------------
     */


    @Test
    void meanSOGWithoutParameters(){
        /**
         * Expected final return value
         */
        double expected = 6;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(mainSogDate1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(mainSogDate2,10,10,6,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainSogDate3,10,10,9,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG());
    }

    @Test
    void meanSOGWithoutParametersSOGZero(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime datetest2 = LocalDateTime.of(2020, 12,30,18,29);
        LocalDateTime datetest3 = LocalDateTime.of(2020, 12,30,19,19);

        PositionData positionDataTestCompare1 = new PositionData(datetest1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(datetest2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(datetest3,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);


        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                           MEAN SOG WITH DATES TESTS
     *
     * ---------------------------------------------------------------------------------------
     */

    @Test
    void meanSOGWithParameters(){
        /**
         * Expected final return value
         */
        double expected = 4.5;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(mainSogDate1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(mainSogDate2,10,10,6,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainSogDate3,10,10,9,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG(mainSogDate1,mainSogDate2));
    }

    @Test
    void meanSOGWithParametersSOGZero(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(mainSogDate1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(mainSogDate2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainSogDate3,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG(mainSogDate1,mainSogDate3));
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  TRAVEL DISTANCE TESTS
     *
     * ---------------------------------------------------------------------------------------
     */


    @Test
    void travelledDistanceTwoPointsSamePosition(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistance());
    }

    @Test
    void travelledDistanceTwoPointsDiffPosition(){
        /**
         * Expected final return value
         */
        double expected = 4751.733107605955;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistance());
    }

    @Test
    void travelledDistanceThreePoints(){
        /**
         * Expected final return value
         */
        double expected = 11057.439248129005;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistance());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         TRAVEL DISTANCE BETWEEN DATES TESTS
     *
     * ---------------------------------------------------------------------------------------
     */

    @Test
    void travelledDistanceTwoPointsSamePositionBtwDates(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistanceBtDates(dateTravelDistance1,dateTravelDistance2));
    }

    @Test
    void travelledDistanceTwoPointsDiffPositionBtwDates(){
        /**
         * Expected final return value
         */
        double expected = 4751.733107605955;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistanceBtDates(dateTravelDistance1, dateTravelDistance2));
    }

    @Test
    void travelledDistanceThreePointsBtwDates(){
        /**
         * Expected final return value
         */
        double expected = 11057.439248129005;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistanceBtDates(dateTravelDistance1,dateTravelDistance3));
    }

    @Test
    void getTotalMovementsTest(){
        /**
         * Expected final return value
         */
        int expected = 3;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().getTotalMovements());
    }

}