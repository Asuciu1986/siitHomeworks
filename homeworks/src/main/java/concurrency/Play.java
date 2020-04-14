package concurrency;

public class Play {

    public static void main(String[] args) {
//        String tip = TicketType.generateRandomTicketType().name();
//        String tip2 = TicketType.generateRandomTicketType().name();
//        String tip3 = TicketType.generateRandomTicketType().name();
//        String tip4 = TicketType.generateRandomTicketType().name();
//        String tip5 = TicketType.generateRandomTicketType().name();
//        String tip6 = TicketType.generateRandomTicketType().name();

        FestivalGate festivalGate = new FestivalGate();
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(festivalGate);
        Thread festivalStatisticsThreadRunnable = new Thread(festivalStatisticsThread);
        festivalStatisticsThreadRunnable.start();

        for (int i = 0; i < 100; i++) {
            FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(festivalGate);
            Thread festivalAttendeeThreadRunnable = new Thread(festivalAttendeeThread);
            festivalAttendeeThreadRunnable.start();
        }


//        System.out.println(tip);
//        System.out.println(tip2);
//        System.out.println(tip3);
//        System.out.println(tip4);
//        System.out.println(tip5);
//        System.out.println(tip6);
    }


}
