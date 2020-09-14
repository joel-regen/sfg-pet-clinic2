package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class  DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner("Jim", "Morrison");
        Owner owner2 = new Owner("Jimmy", "Stewart");
        Vet vet1 = new Vet("Ron", "Smith");
        Vet vet2 = new Vet("Rod", "Johnson");
        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loaded owners...");
        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }
}
