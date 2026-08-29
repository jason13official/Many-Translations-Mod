package io.github.jason13official.many_translations;

import java.util.function.Consumer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class ManyTranslationsClientNeoForge {

  public ManyTranslationsClientNeoForge(final IEventBus modEventBus) {

    modEventBus.addListener((Consumer<FMLClientSetupEvent>) event -> ManyTranslationsClient.init());
  }
}
