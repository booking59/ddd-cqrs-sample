package pl.com.bottega.erp.shipping.application.commands.handlers;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import pl.com.bottega.cqrs.command.handler.CommandHandler;
import pl.com.bottega.cqrs.command.handler.CommandHandlerAnnotation;
import pl.com.bottega.erp.shipping.application.commands.SendShipmentCommand;
import pl.com.bottega.erp.shipping.domain.Shipment;
import pl.com.bottega.erp.shipping.domain.ShipmentRepository;

@CommandHandlerAnnotation
@Named
@Stateless
public class ShipOrderCommandHandler implements CommandHandler<SendShipmentCommand, Void> {

    @Inject
    private ShipmentRepository repository;

    @Override
    public Void handle(SendShipmentCommand command) {
        Shipment shipment = repository.load(command.getShipmentId());
        shipment.ship();
        return null;
    }
}
