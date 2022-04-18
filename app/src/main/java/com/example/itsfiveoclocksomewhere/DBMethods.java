package com.example.itsfiveoclocksomewhere;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBMethods {

    public UserDao ud;
    public SpecialDao sd;
    public BarDao bd;

    public DBMethods(AppDatabase db){
        ud = db.userDao();
        sd = db.specialDao();
        bd = db.barDao();
        populateAllDBs(ud, sd, bd);
        DBMethods.testWorks(db);

    }


    public static List<Bar> populateBar(BarDao db) {
        List<Bar> bars= new ArrayList<>();
        Bar one = new Bar(1, "Fourth Street Taproom & Kitchen", "1810 N 4th St, Columbus, OH 43201",
                "Closed", "3PM - 2AM", "3PM - 2AM",
                "3PM - 2AM", "12PM - 2 AM", "11AM - 2AM",
                "11AM - 2AM");
        bars.add(one);
        Bar two = new Bar(2, "Brothers Bar & Grill", "477 Park St, Columbus, OH 43215",
                "3PM - 2AM", "3PM - 2AM", "3PM - 2AM",
                "3PM - 2AM", "3PM - 2AM", "3PM - 2AM",
                "Closed");
        bars.add(two);

        Bar three = new Bar(3, "Midway", "1728 N High St, Columbus, OH 43201",
                "Closed", "Closed", "9PM - 2AM",
                "8PM - 2AM", "3PM - 2AM", "3PM - 2AM",
                "Closed");
        bars.add(three);

        Bar four = new Bar(4, "Ethyl & Tank", "19 E 13th Ave, Columbus, OH 43201",
                "Closed", "12PM - 2AM", "12PM - 2AM",
                "12PM - 2AM", "12PM - 2AM", "10AM - 2AM",
                "10AM - 8PM");
        bars.add(four);

        Bar five = new Bar(5, "Out-R-Inn", "20 Frambes Ave, Columbus, OH 43201",
                "Closed", "4PM - 2:30AM", "4PM - 2:30AM",
                "4PM - 2:30AM", "4PM - 2:30AM", "4PM - 2:30AM",
                "Closed");
        bars.add(five);

        Bar six = new Bar(6, "The Library Bar", "2169 N High St, Columbus, OH 43201",
                "3PM - 2:30AM", "3PM - 2:30AM", "3PM - 2:30AM",
                "3PM - 2:30AM", "1PM - 2AM", "1PM - 2AM",
                "3PM - 2:30AM");
        bars.add(six);

        Bar seven = new Bar(7, "The Little Bar", "2195 N High St, Columbus, OH 43201",
                "4PM - 2AM", "4PM - 2AM", "4PM - 2AM",
                "4PM - 2AM", "3:30PM - 2AM", "3:30PM - 2AM",
                "3:30PM - 2AM");
        bars.add(seven);

        Bar eight = new Bar(8, "Threes Above High", "2203 N High St, Columbus, OH 43201",
                "Closed", "7PM - 2AM", "7PM - 2AM",
                "7PM - 2AM", "7PM - 2AM", "7PM - 2AM",
                "Closed");
        bars.add(eight);

        Bar nine = new Bar(9, "Ugly Tuna Saloona 2", "195 Chittenden Ave, Columbus, OH 43201",
                "4PM - 2AM", "4PM - 2AM", "4PM - 2AM",
                "4PM - 2AM", "4PM - 2AM", "4PM - 2AM",
                "4PM - 2AM");
        bars.add(nine);

        Bar ten = new Bar(10, "Standard Hall", "1100 N High St, Columbus, OH 43201",
                "Closed", "3PM - 2AM", "3PM - 2AM",
                "3PM - 2AM", "3PM - 2AM", "11AM - 2AM",
                "11AM - 12AM");
        bars.add(ten);

        Bar eleven = new Bar(11, "Bodega", "1044 N High St, Columbus, OH 43201",
                "3PM - 12AM", "3PM - 12AM", "3PM - 12AM",
                "3PM - 12AM", "3PM - 2AM", "11AM - 2AM",
                "11AM - 9PM");
        bars.add(eleven);

        Bar twelve = new Bar(12, "Bristol Republic", "1124 N High St, Columbus, OH 43201",
                "Closed", "Closed", "Closed",
                "4PM - 12AM", "4PM - 2:30AM", "10AM - 2:30AM",
                "10AM - 10PM");
        bars.add(twelve);

        Bar thirteen = new Bar(13, "Gaswerks", "487 Park St, Columbus, OH 43215",
                "Closed", "Closed", "5PM - 2AM",
                "5PM - 2AM", "5PM - 2AM", "5PM - 2AM",
                "Closed");
        bars.add(thirteen);

        Bar fourteen = new Bar(14, "The Big Bang Dueling Piano Bar", "1516 N High St, Columbus, OH 43201",
                "Closed", "Closed", "Closed",
                "7PM - 2AM", "7PM - 2AM", "7PM - 2AM",
                "Closed");
        bars.add(fourteen);

        Bar fifteen = new Bar(15, "Bier Stube", "1479 N High St, Columbus, OH 43201",
                "3PM - 2:30AM", "3PM - 2:30AM", "3PM - 2:30AM",
                "3PM - 2:30AM", "3PM - 2:30AM", "3PM - 2:30AM",
                "3PM - 2:30AM");
        bars.add(fifteen);

        Bar sixteen = new Bar(16, "Plaza Mexican Grill & Bar", "1644 N High St, Columbus, OH 43201",
                "3PM - 11PM", "3PM - 11PM", "3PM - 11PM",
                "3PM - 12AM", "12PM - 12AM", "12PM - 12AM",
                "Closed");
        bars.add(sixteen);

        Bar seventeen = new Bar(17, "Cazuelas Mexican Cantina", "2321 N High St, Columbus, OH 43202",
                "11AM - 12AM", "11AM - 12AM", "11AM - 1AM",
                "11AM - 2AM", "11AM - 2AM", "11AM - 12AM",
                "11AM - 12AM");
        bars.add(seventeen);

        Bar eighteen = new Bar(18, "Leo's on the Alley", "25 Chittenden Ave, Columbus, OH 43201",
                "5PM - 2AM", "5PM - 2AM", "5PM - 2AM",
                "5PM - 2AM", "5PM - 2AM", "5PM - 2AM",
                "Closed");
        bars.add(eighteen);

        Bar nineteen = new Bar(19, "The Thirsty Scholar", "2201 Neil Ave, Columbus, OH 43201",
                "3PM - 2:30AM", "3PM - 2:30AM", "3PM - 2:30AM",
                "3PM - 2:30AM", "3PM - 2:30AM", "5PM - 2:30AM",
                "Closed");
        bars.add(nineteen);

        Bar twenty = new Bar(20, "Bullwinkles Night Club/Bar", "1770 N High St, Columbus, OH 43201",
                "Closed", "Closed", "Closed",
                "9PM - 2:30AM", "9PM - 2:30AM", "9PM - 2:30AM",
                "Closed");
        bars.add(twenty);



        db.insertAllBars(one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve,
                thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty);

        return bars;
    }

    public static void populateUsers(UserDao db) {
        User one = new User(1, "landenman", "coolDude!", "N/A", "N/A");
        User two = new User(2, "noahs_account", "Testing23", "N/A", "N/A");
        User three = new User(3, "mikaela-drinks", "1LastDrink", "N/A", "N/A");
        User four = new User(4, "Ben10", "Pach3co", "N/A", "N/A");
        User five = new User(5, "Glub-Glub", "PleaseDontReadThis", "N/A", "N/A");
        User six = new User(6, "StinkB*g", "P00ter", "N/A", "N/A");
        User seven = new User(7, "KingJames", "G0@t", "N/A", "N/A");
        User eight = new User(8, "Badzikky", "But_I'mNotARapper", "N/A", "N/A");
        User nine = new User(9, "12AngryMen", "Class!cMovie", "N/A", "N/A");
        User ten = new User(10, "landenmantwo", "evencoolerDude!", "N/A", "N/A");
        User eleven = new User(11, "uhimrunningout", "plzhelp", "N/A", "N/A");
        User twelve = new User(12, "this!is!hard!", "Cr_e@tivity", "N/A", "N/A");
        User thirteen = new User(13, "BrutusBuckeye", "Hang0nSl33py", "N/A", "N/A");
        User fourteen = new User(14, "reference", "nowlaugh", "N/A", "N/A");
        User fifteen = new User(15, "BenKingsly", "UhCool?", "N/A", "N/A");
        User sixteen = new User(16, "ledZepplin", "HeyHeyMamaSayTheWayYouMove", "N/A", "N/A");
        User seventeen = new User(17, "jokepart2", "GonnaMakeYouSweatGonnaMakeYouGrove", "N/A", "N/A");
        User eighteen = new User(18, "wait1more", "NahNahNahNahNahNahNahNahNahNahNahNahNahNahNahNahNah", "N/A", "N/A");
        User nineteen = new User(19, "finishLine", "AndHe'sPlacing2nd", "N/A", "N/A");
        User twenty = new User(20, "lastOne", "watchmeWhipNaeNae", "N/A", "N/A");
        db.insertAllUsers(one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve,
                thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty);
    }

    public static List<Special> populateSpecials(SpecialDao db) {
        List<Special> specialList = new ArrayList<Special>();
       Special one = new Special(1, 0, 0, 1, 7, 2,
                "16oz budweiser: $3|PBR tallboy: $3|16oz platform - haze jude: $4|paper tiger draft: $3|bomb special");
        specialList.add(one);
        Special two = new Special(1, 1, 15, 2, 2, 2,
                "half off all drinks");
        specialList.add(two);

        Special three = new Special(2, 1, 15, 19, 3, 7,
                "$2 off all drinks");
        specialList.add(three);

        Special four = new Special(3, 1, 15, 2, 3, 3,
                "16oz half off pink whitney");
        specialList.add(four);

        Special five = new Special(4, 1, 15, 19, 2, 5,
                "half off all apps");
        specialList.add(five);

        Special six = new Special(5, 2, 21, 2, 1, 1,
                "$2 Wells|$3 Hot Shots|$4 Any Draft|$5 32oz OG LIT Pitchers");
        specialList.add(six);

        Special seven = new Special(6, 2, 17, 22, 2, 2,
                "$2 CHZBURGERS");
        specialList.add(seven);

        Special eight = new Special(7, 2, 21, 2, 2, 2,
                "$3 Wells|$3 Hot Shots|$3 Domestic Bottles");
        specialList.add(eight);

        Special nine = new Special(8, 2, 21, 2, 3, 3,
                "40¢ Wings|$4 Double Wells|$5 Large Domestic Drafts|$6 Large Craft Drafts");
        specialList.add(nine);

        Special ten = new Special(9, 2, 21, 2, 4, 4,
                "$2 Double Wells|$3 Domestic Bottles|$3 Cherry or Grape Bombs|$4 32oz. OG LIT Pitchers");
        specialList.add(ten);

        Special eleven = new Special(10, 2, 21, 2, 5, 5,
                "$3 Double Wells|$3 Tito's|$4 Domestic Bottles|$8 32oz. OG LIT Pitchers");
        specialList.add(eleven);

        Special twelve = new Special(11, 2, 21, 2, 6, 6,
                "$4 Fireball|$4 Cherry/Grape Bombs|$6 Vodka Red Bulls|$6 Vegas Bombs");
        specialList.add(twelve);

        Special thirteen = new Special(12, 2, 21, 2, 7, 7,
                "$2 Mimosas|$4 Double Wells|$4 Calls|$4 Large Domestic Drafts|$5 Large Craft/Import Drafts");
        specialList.add(thirteen);

        Special fourteen = new Special(13, 3, 21, 2, 3, 3,
                "$5 DOUBLE REDBULL VODKA|$3 PINK WHITNEYS");
        specialList.add(fourteen);

        Special fifteen = new Special(14, 3, 20, 2, 4, 4,
                "$1 WELLS FOR THE LADIES|$2 PINK TEA|$2 TITOS|$5 MIDWAY MILK");
        specialList.add(fifteen);

        Special sixteen = new Special(15, 3, 15, 18, 5, 6,
                "$1 wells|$1 bombs");
        specialList.add(sixteen);

        Special seventeen = new Special(16, 3, 18, 21, 5, 6,
                "$2 off everything");
        specialList.add(seventeen);

        Special eighteen = new Special(17, 4, 12, 16, 2, 4,
                "50% off drafts|25% off Handhelds");
        specialList.add(eighteen);

        Special nineteen = new Special(18, 4, 16, 19, 2, 4,
                "50% off wells|50% off drafts|25% off Specialty Cocktails");
        specialList.add(nineteen);

        Special twenty = new Special(19, 14, 12, 2, 2, 2,
                "$1 tacos|$5 frozen margarita|$10 margarita pitchers");
        specialList.add(twenty);

        Special twentyone = new Special(20, 4, 12, 2, 3, 3,
                "25% off appetizers|25% off shareable cocktails");
        specialList.add(twentyone);

        Special twentytwo = new Special(21, 4, 12, 2, 4, 4,
                "$5 nachos|$5 big tanks");
        specialList.add(twentytwo);

        Special twentythree = new Special(22,4, 12, 17, 5, 5,
                "DOMESTIC PITCHERS: $2 @ 12:00, $3 @ 1:00 $4 @ 2:00, $5 @ 3:00 $6 @ 4:00");
        specialList.add(twentythree);

        Special twentyfour = new Special(23, 4, 18, 21, 5, 6,
                "$20 bottomless mimosas|$4 irish breakfast shots");
        specialList.add(twentyfour);


        db.insertAllSpecials(one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve,
                thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty, twentyone,
                twentytwo, twentythree, twentyfour);

        return specialList;
    }

    public static void testWorks(AppDatabase db) {

        System.out.println(Arrays.toString(db.barDao().getAllBars().toArray()));
        System.out.println(Arrays.toString(db.userDao().getAllUsers().toArray()));
        System.out.println(Arrays.toString(db.specialDao().getAllSpecials().toArray()));


    }

    public static void populateAllDBs(UserDao u, SpecialDao s, BarDao b){
        populateBar(b);
    }

    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    public static LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude());

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return p1;
    }


}
