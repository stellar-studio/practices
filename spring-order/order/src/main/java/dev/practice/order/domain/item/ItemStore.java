package dev.practice.order.domain.item;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public interface ItemStore {
    Item store(Item initItem);
}
