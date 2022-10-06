package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            //영속성 컨텍스트로 1차 캐시에 들어가 있기에 호출 안됨
            //만약 쿼리를 보고싶으면 em.flush(), em.clear() 실행
            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
