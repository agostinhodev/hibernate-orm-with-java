package classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
				
		Departamento d = new Departamento();
		//d.setNome("Cobranca");
		d.setId(3);
		
		
		Funcionario f = new Funcionario();
		
				
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("seuPU");
		EntityManager em = eMF.createEntityManager();
		
		f = em.find(Funcionario.class, 1);
		
		List<Funcionario> funcionarios = null;
		funcionarios = em.createQuery("FROM Funcionario").getResultList();
		
		for (Funcionario funcionario : funcionarios) {
			
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getDepartamento().getNome());
			System.out.println(funcionario.getDepartamento().getId());
			
		}
		
		//;
		/*em.getTransaction().begin();
		em.persist(f);*/
		/*em.merge(d);*/
		/*em.remove(d);*/
		
		/*d = em.find(Departamento.class, 1);
		System.out.println(d.getNome());
		
		em.remove(d);	*/
		/*em.getTransaction().commit();
		List<Departamento> departamentos = null;
		departamentos = em.createQuery("FROM Departamento").getResultList();
		
		for(int i = 0; i < departamentos.size(); i++) {
									
			System.out.println(departamentos.get(i).getId() + "\n" + departamentos.get(i).getNome());
			
		}*/
		
		
		eMF.close();
		em.close();
		
		
	}

}

