package mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);
            // 멤버 저장
            Member member = new Member();
            member.setName("member1");
            //            member.setTeamId(team.getId());
            member.changeTeam(team);
            em.persist(member);

//            em.flush();
//            em.clear();
            // 조회
            Team findTeam = em.find(Team.class, team.getId());

            for(Member m : findTeam.getMembers()){
                System.out.println("m = " + m.getName());
            }

            /* 테이블 기준 매핑
//            Long findTeamId = findMember.getTeamId();
//            Team fineTeam = em.find(Team.class, findTeamId);
            */
            /* 객체 지향 매핑
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            // 멤버가 새로운 팀에 합류
            Team newTeam = em.find(Team.class, 100L); // 100번 팀이 있다고 가정
            findMember.setTeam(newTeam);
            */
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
