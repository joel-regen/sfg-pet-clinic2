package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class  DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner(1L, "Jim", "Morrison");
        Owner owner2 = new Owner(2L, "Jimmy", "Stewart");
        Vet vet1 = new Vet(1L, "Ron", "Smith");
        Vet vet2 = new Vet(2L, "Rod", "Johnson");
        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loaded owners...");
        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }
}
