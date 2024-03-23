import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List <String> list = Files.readAllLines(new File("C:\\Users\\182\\IdeaProjects\\Test1\\src\\schedule.txt").toPath(), Charset.defaultCharset());

        // 5
        List<Program> programs = new ArrayList<>();
        String currentChannel = null;
        BroadcastsTime currentTime = null;

        for (String line : list) {
            if (line.startsWith("#")) {
                currentChannel = line.substring(1).trim();
            } else if (line.matches("\\d{2}:\\d{2}")) {
                currentTime = new BroadcastsTime(line);
            } else {
                programs.add(new Program(currentChannel, currentTime, line));
            }
        }

        // 4
        Map<String, List<Program>> programMap = new HashMap<>();
        for(Program program: programs){
            if (! programMap.containsKey(program.getChannel())){
                programMap.put(program.getChannel(), new ArrayList<>());
            }
            programMap.get(program.getChannel()).add(program);
        }

        // 6
        Collections.sort(programs, Comparator.comparing(Program::getTime));
        System.out.println(programs);

        // 7
        List<Program> programsNow = new ArrayList<>();
        currentTime = new BroadcastsTime("03:55");
        for (Program program : programs) {
            if (program.getTime().equals(currentTime)) {
                programsNow.add(program);
            }
        }

        // 8
        List<Program> programsByName = new ArrayList<>();
        String neededName = "Деловые люди";
        for (Program program : programs) {
            if (program.getName().equals(neededName)) {
                programsByName.add(program);
            }
        }
        System.out.println(programsByName);

        //9-10
        List<Program> programsByChannelAndTime = new ArrayList<>();
        BroadcastsTime timeNeeded = new BroadcastsTime("23:50");
        String channelNeeded = "Первый";
        for (Program program : programs) {
            if (program.getTime().equals(timeNeeded) && program.getChannel().equals(channelNeeded)) {
                programsByChannelAndTime.add(program);
            }
        }
        System.out.println(programsByChannelAndTime);
    }
}
