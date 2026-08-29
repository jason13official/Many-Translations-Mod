package io.github.jason13official.many_translations;

import net.fabricmc.api.ClientModInitializer;

public class ManyTranslationsClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {

    ManyTranslationsClient.init();
  }
}
