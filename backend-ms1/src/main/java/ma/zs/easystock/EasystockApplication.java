package ma.zs.easystock;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;
import com.fasterxml.jackson.databind.SerializationFeature;


import ma.zs.easystock.zynerator.security.common.AuthoritiesConstants;
import ma.zs.easystock.zynerator.security.bean.User;
import ma.zs.easystock.zynerator.security.bean.Permission;
import ma.zs.easystock.zynerator.security.bean.Role;
import ma.zs.easystock.zynerator.security.service.facade.UserService;
import ma.zs.easystock.zynerator.security.service.facade.RoleService;

//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableElasticsearchRepositories("ma.zs.easystock.dao")
//@EnableFeignClients("ma.zs.easystock.required.facade")
public class EasystockApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(EasystockApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Proprietaire.edit"));
        permissions.add(new Permission("Proprietaire.list"));
        permissions.add(new Permission("Proprietaire.view"));
        permissions.add(new Permission("Proprietaire.add"));
        permissions.add(new Permission("Proprietaire.delete"));
        permissions.add(new Permission("EtatTransaction.edit"));
        permissions.add(new Permission("EtatTransaction.list"));
        permissions.add(new Permission("EtatTransaction.view"));
        permissions.add(new Permission("EtatTransaction.add"));
        permissions.add(new Permission("EtatTransaction.delete"));
        permissions.add(new Permission("AvoirVente.edit"));
        permissions.add(new Permission("AvoirVente.list"));
        permissions.add(new Permission("AvoirVente.view"));
        permissions.add(new Permission("AvoirVente.add"));
        permissions.add(new Permission("AvoirVente.delete"));
        permissions.add(new Permission("SortieProduitItem.edit"));
        permissions.add(new Permission("SortieProduitItem.list"));
        permissions.add(new Permission("SortieProduitItem.view"));
        permissions.add(new Permission("SortieProduitItem.add"));
        permissions.add(new Permission("SortieProduitItem.delete"));
        permissions.add(new Permission("ReglementVente.edit"));
        permissions.add(new Permission("ReglementVente.list"));
        permissions.add(new Permission("ReglementVente.view"));
        permissions.add(new Permission("ReglementVente.add"));
        permissions.add(new Permission("ReglementVente.delete"));
        permissions.add(new Permission("ProprietaireBanque.edit"));
        permissions.add(new Permission("ProprietaireBanque.list"));
        permissions.add(new Permission("ProprietaireBanque.view"));
        permissions.add(new Permission("ProprietaireBanque.add"));
        permissions.add(new Permission("ProprietaireBanque.delete"));
        permissions.add(new Permission("ModeReglement.edit"));
        permissions.add(new Permission("ModeReglement.list"));
        permissions.add(new Permission("ModeReglement.view"));
        permissions.add(new Permission("ModeReglement.add"));
        permissions.add(new Permission("ModeReglement.delete"));
        permissions.add(new Permission("Taxe.edit"));
        permissions.add(new Permission("Taxe.list"));
        permissions.add(new Permission("Taxe.view"));
        permissions.add(new Permission("Taxe.add"));
        permissions.add(new Permission("Taxe.delete"));
        permissions.add(new Permission("EntreeProduit.edit"));
        permissions.add(new Permission("EntreeProduit.list"));
        permissions.add(new Permission("EntreeProduit.view"));
        permissions.add(new Permission("EntreeProduit.add"));
        permissions.add(new Permission("EntreeProduit.delete"));
        permissions.add(new Permission("AchatItem.edit"));
        permissions.add(new Permission("AchatItem.list"));
        permissions.add(new Permission("AchatItem.view"));
        permissions.add(new Permission("AchatItem.add"));
        permissions.add(new Permission("AchatItem.delete"));
        permissions.add(new Permission("Categorie.edit"));
        permissions.add(new Permission("Categorie.list"));
        permissions.add(new Permission("Categorie.view"));
        permissions.add(new Permission("Categorie.add"));
        permissions.add(new Permission("Categorie.delete"));
        permissions.add(new Permission("CommandeItem.edit"));
        permissions.add(new Permission("CommandeItem.list"));
        permissions.add(new Permission("CommandeItem.view"));
        permissions.add(new Permission("CommandeItem.add"));
        permissions.add(new Permission("CommandeItem.delete"));
        permissions.add(new Permission("ReglementAvoirAchat.edit"));
        permissions.add(new Permission("ReglementAvoirAchat.list"));
        permissions.add(new Permission("ReglementAvoirAchat.view"));
        permissions.add(new Permission("ReglementAvoirAchat.add"));
        permissions.add(new Permission("ReglementAvoirAchat.delete"));
        permissions.add(new Permission("EtatAvoirVente.edit"));
        permissions.add(new Permission("EtatAvoirVente.list"));
        permissions.add(new Permission("EtatAvoirVente.view"));
        permissions.add(new Permission("EtatAvoirVente.add"));
        permissions.add(new Permission("EtatAvoirVente.delete"));
        permissions.add(new Permission("Achat.edit"));
        permissions.add(new Permission("Achat.list"));
        permissions.add(new Permission("Achat.view"));
        permissions.add(new Permission("Achat.add"));
        permissions.add(new Permission("Achat.delete"));
        permissions.add(new Permission("BonPourItem.edit"));
        permissions.add(new Permission("BonPourItem.list"));
        permissions.add(new Permission("BonPourItem.view"));
        permissions.add(new Permission("BonPourItem.add"));
        permissions.add(new Permission("BonPourItem.delete"));
        permissions.add(new Permission("EtatAvoirAchat.edit"));
        permissions.add(new Permission("EtatAvoirAchat.list"));
        permissions.add(new Permission("EtatAvoirAchat.view"));
        permissions.add(new Permission("EtatAvoirAchat.add"));
        permissions.add(new Permission("EtatAvoirAchat.delete"));
        permissions.add(new Permission("Depense.edit"));
        permissions.add(new Permission("Depense.list"));
        permissions.add(new Permission("Depense.view"));
        permissions.add(new Permission("Depense.add"));
        permissions.add(new Permission("Depense.delete"));
        permissions.add(new Permission("VenteItem.edit"));
        permissions.add(new Permission("VenteItem.list"));
        permissions.add(new Permission("VenteItem.view"));
        permissions.add(new Permission("VenteItem.add"));
        permissions.add(new Permission("VenteItem.delete"));
        permissions.add(new Permission("Devis.edit"));
        permissions.add(new Permission("Devis.list"));
        permissions.add(new Permission("Devis.view"));
        permissions.add(new Permission("Devis.add"));
        permissions.add(new Permission("Devis.delete"));
        permissions.add(new Permission("Depot.edit"));
        permissions.add(new Permission("Depot.list"));
        permissions.add(new Permission("Depot.view"));
        permissions.add(new Permission("Depot.add"));
        permissions.add(new Permission("Depot.delete"));
        permissions.add(new Permission("AvoirAchatItem.edit"));
        permissions.add(new Permission("AvoirAchatItem.list"));
        permissions.add(new Permission("AvoirAchatItem.view"));
        permissions.add(new Permission("AvoirAchatItem.add"));
        permissions.add(new Permission("AvoirAchatItem.delete"));
        permissions.add(new Permission("ReglementAchat.edit"));
        permissions.add(new Permission("ReglementAchat.list"));
        permissions.add(new Permission("ReglementAchat.view"));
        permissions.add(new Permission("ReglementAchat.add"));
        permissions.add(new Permission("ReglementAchat.delete"));
        permissions.add(new Permission("InventaireItem.edit"));
        permissions.add(new Permission("InventaireItem.list"));
        permissions.add(new Permission("InventaireItem.view"));
        permissions.add(new Permission("InventaireItem.add"));
        permissions.add(new Permission("InventaireItem.delete"));
        permissions.add(new Permission("Fournisseur.edit"));
        permissions.add(new Permission("Fournisseur.list"));
        permissions.add(new Permission("Fournisseur.view"));
        permissions.add(new Permission("Fournisseur.add"));
        permissions.add(new Permission("Fournisseur.delete"));
        permissions.add(new Permission("Produit.edit"));
        permissions.add(new Permission("Produit.list"));
        permissions.add(new Permission("Produit.view"));
        permissions.add(new Permission("Produit.add"));
        permissions.add(new Permission("Produit.delete"));
        permissions.add(new Permission("TypeTransaction.edit"));
        permissions.add(new Permission("TypeTransaction.list"));
        permissions.add(new Permission("TypeTransaction.view"));
        permissions.add(new Permission("TypeTransaction.add"));
        permissions.add(new Permission("TypeTransaction.delete"));
        permissions.add(new Permission("UniteMesure.edit"));
        permissions.add(new Permission("UniteMesure.list"));
        permissions.add(new Permission("UniteMesure.view"));
        permissions.add(new Permission("UniteMesure.add"));
        permissions.add(new Permission("UniteMesure.delete"));
        permissions.add(new Permission("Stock.edit"));
        permissions.add(new Permission("Stock.list"));
        permissions.add(new Permission("Stock.view"));
        permissions.add(new Permission("Stock.add"));
        permissions.add(new Permission("Stock.delete"));
        permissions.add(new Permission("Compte.edit"));
        permissions.add(new Permission("Compte.list"));
        permissions.add(new Permission("Compte.view"));
        permissions.add(new Permission("Compte.add"));
        permissions.add(new Permission("Compte.delete"));
        permissions.add(new Permission("EtatCommande.edit"));
        permissions.add(new Permission("EtatCommande.list"));
        permissions.add(new Permission("EtatCommande.view"));
        permissions.add(new Permission("EtatCommande.add"));
        permissions.add(new Permission("EtatCommande.delete"));
        permissions.add(new Permission("ChequeEffet.edit"));
        permissions.add(new Permission("ChequeEffet.list"));
        permissions.add(new Permission("ChequeEffet.view"));
        permissions.add(new Permission("ChequeEffet.add"));
        permissions.add(new Permission("ChequeEffet.delete"));
        permissions.add(new Permission("TransactionFournisseur.edit"));
        permissions.add(new Permission("TransactionFournisseur.list"));
        permissions.add(new Permission("TransactionFournisseur.view"));
        permissions.add(new Permission("TransactionFournisseur.add"));
        permissions.add(new Permission("TransactionFournisseur.delete"));
        permissions.add(new Permission("Inventaire.edit"));
        permissions.add(new Permission("Inventaire.list"));
        permissions.add(new Permission("Inventaire.view"));
        permissions.add(new Permission("Inventaire.add"));
        permissions.add(new Permission("Inventaire.delete"));
        permissions.add(new Permission("Transfert.edit"));
        permissions.add(new Permission("Transfert.list"));
        permissions.add(new Permission("Transfert.view"));
        permissions.add(new Permission("Transfert.add"));
        permissions.add(new Permission("Transfert.delete"));
        permissions.add(new Permission("TransfertItem.edit"));
        permissions.add(new Permission("TransfertItem.list"));
        permissions.add(new Permission("TransfertItem.view"));
        permissions.add(new Permission("TransfertItem.add"));
        permissions.add(new Permission("TransfertItem.delete"));
        permissions.add(new Permission("Vente.edit"));
        permissions.add(new Permission("Vente.list"));
        permissions.add(new Permission("Vente.view"));
        permissions.add(new Permission("Vente.add"));
        permissions.add(new Permission("Vente.delete"));
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.list"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.add"));
        permissions.add(new Permission("Commande.delete"));
        permissions.add(new Permission("AvoirAchat.edit"));
        permissions.add(new Permission("AvoirAchat.list"));
        permissions.add(new Permission("AvoirAchat.view"));
        permissions.add(new Permission("AvoirAchat.add"));
        permissions.add(new Permission("AvoirAchat.delete"));
        permissions.add(new Permission("SortieProduit.edit"));
        permissions.add(new Permission("SortieProduit.list"));
        permissions.add(new Permission("SortieProduit.view"));
        permissions.add(new Permission("SortieProduit.add"));
        permissions.add(new Permission("SortieProduit.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("EtatAchat.edit"));
        permissions.add(new Permission("EtatAchat.list"));
        permissions.add(new Permission("EtatAchat.view"));
        permissions.add(new Permission("EtatAchat.add"));
        permissions.add(new Permission("EtatAchat.delete"));
        permissions.add(new Permission("Raison.edit"));
        permissions.add(new Permission("Raison.list"));
        permissions.add(new Permission("Raison.view"));
        permissions.add(new Permission("Raison.add"));
        permissions.add(new Permission("Raison.delete"));
        permissions.add(new Permission("EntreeProduitItem.edit"));
        permissions.add(new Permission("EntreeProduitItem.list"));
        permissions.add(new Permission("EntreeProduitItem.view"));
        permissions.add(new Permission("EntreeProduitItem.add"));
        permissions.add(new Permission("EntreeProduitItem.delete"));
        permissions.add(new Permission("Marque.edit"));
        permissions.add(new Permission("Marque.list"));
        permissions.add(new Permission("Marque.view"));
        permissions.add(new Permission("Marque.add"));
        permissions.add(new Permission("Marque.delete"));
        permissions.add(new Permission("EntrepriseSociete.edit"));
        permissions.add(new Permission("EntrepriseSociete.list"));
        permissions.add(new Permission("EntrepriseSociete.view"));
        permissions.add(new Permission("EntrepriseSociete.add"));
        permissions.add(new Permission("EntrepriseSociete.delete"));
        permissions.add(new Permission("ReglementAvoirVente.edit"));
        permissions.add(new Permission("ReglementAvoirVente.list"));
        permissions.add(new Permission("ReglementAvoirVente.view"));
        permissions.add(new Permission("ReglementAvoirVente.add"));
        permissions.add(new Permission("ReglementAvoirVente.delete"));
        permissions.add(new Permission("BonPour.edit"));
        permissions.add(new Permission("BonPour.list"));
        permissions.add(new Permission("BonPour.view"));
        permissions.add(new Permission("BonPour.add"));
        permissions.add(new Permission("BonPour.delete"));
        permissions.add(new Permission("Tache.edit"));
        permissions.add(new Permission("Tache.list"));
        permissions.add(new Permission("Tache.view"));
        permissions.add(new Permission("Tache.add"));
        permissions.add(new Permission("Tache.delete"));
        permissions.add(new Permission("TypeInstrument.edit"));
        permissions.add(new Permission("TypeInstrument.list"));
        permissions.add(new Permission("TypeInstrument.view"));
        permissions.add(new Permission("TypeInstrument.add"));
        permissions.add(new Permission("TypeInstrument.delete"));
        permissions.add(new Permission("Collaborateur.edit"));
        permissions.add(new Permission("Collaborateur.list"));
        permissions.add(new Permission("Collaborateur.view"));
        permissions.add(new Permission("Collaborateur.add"));
        permissions.add(new Permission("Collaborateur.delete"));
        permissions.add(new Permission("EtatVente.edit"));
        permissions.add(new Permission("EtatVente.list"));
        permissions.add(new Permission("EtatVente.view"));
        permissions.add(new Permission("EtatVente.add"));
        permissions.add(new Permission("EtatVente.delete"));
        permissions.add(new Permission("DevisItem.edit"));
        permissions.add(new Permission("DevisItem.list"));
        permissions.add(new Permission("DevisItem.view"));
        permissions.add(new Permission("DevisItem.add"));
        permissions.add(new Permission("DevisItem.delete"));
        permissions.add(new Permission("AvoirVenteItem.edit"));
        permissions.add(new Permission("AvoirVenteItem.list"));
        permissions.add(new Permission("AvoirVenteItem.view"));
        permissions.add(new Permission("AvoirVenteItem.add"));
        permissions.add(new Permission("AvoirVenteItem.delete"));
        permissions.add(new Permission("Banque.edit"));
        permissions.add(new Permission("Banque.list"));
        permissions.add(new Permission("Banque.view"));
        permissions.add(new Permission("Banque.add"));
        permissions.add(new Permission("Banque.delete"));
    }

}


