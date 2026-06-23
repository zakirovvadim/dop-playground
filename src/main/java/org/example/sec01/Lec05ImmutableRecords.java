package org.example.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Lec05ImmutableRecords {
    private static final Logger log = LoggerFactory.getLogger(Lec04NonCanonicalConstructor.class);

    record Team (String name, List<String> members) {
        Team{
            members = List.copyOf(members); // рекорды не полностью иммутабельны, лист можно изменить,
            // если намеренно его не сделать неизменяемым (но и то, в данном примере это стринг, но елси это объект,
            // то его сеттеры будут доступны)
        }
    }


    public static void main(String[] args) {
        var members = new ArrayList<String>();
        members.add("vadim");
        members.add("mariia");
        Team devTeam = new Team("dev team", members);
        log.info("{}", devTeam);
        devTeam.members.add("albert");
        log.info("{}", devTeam);
    }
}
