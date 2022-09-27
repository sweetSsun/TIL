package hellojpa;

import inheritance.Movie;

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
//            // 등록
//            /* 비영속 */
//            Member member = new Member();
//            member.setId("ID_A");
//            member.setUsername("C");

//            /* 영속 */
//            em.persist(member);

//            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());
//            /* 1차 캐시에서 조회되는 것 */
//            Member findMember2 = em.find(Member.class, 1L);
//            System.out.println("result = " + (findMember == findMember2));

//            // 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            //JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
////                    .setFirstResult(5)
////                    .setMaxResults(10)
//                    .getResultList();
//            for(Member member : result){
//                System.out.println("member.name = " + member.getName());
//            }

            Movie movie = new Movie();
            movie.setDirector("AAA");
            movie.setActor("BBB");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMove = em.find(Movie.class, movie.getId());
            System.out.println("fineMove : " + findMove);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
