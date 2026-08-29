package io.github.jason13official.many_translations.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.client.resources.language.ClientLanguage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/// Merge on top of the base in filename order; later files win on collisions
@Mixin(ClientLanguage.class)
public class ClientLanguageMixin {

  @Redirect(method = "loadFrom", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/resources/ResourceManager;getResourceStack(Lnet/minecraft/resources/ResourceLocation;)Ljava/util/List;"))
  private static List<Resource> many_translations$loadFrom(ResourceManager resourceManager, ResourceLocation location) {

    List<Resource> stack = new ArrayList<>(resourceManager.getResourceStack(location));

    String path = location.getPath();
    int slash = path.indexOf('/');
    int dot = path.lastIndexOf('.');
    if (slash < 0 || dot < slash) {
      return stack;
    }

    String directory = path.substring(0, slash);
    String prefix = path.substring(0, dot) + "_";
    String suffix = path.substring(dot);
    String namespace = location.getNamespace();

    resourceManager.listResourceStacks(directory, id -> id.getNamespace().equals(namespace) && id.getPath().startsWith(prefix) && id.getPath().endsWith(suffix)).entrySet().stream()
        .sorted(Map.Entry.comparingByKey()).forEach(entry -> stack.addAll(entry.getValue()));

    return stack;
  }
}
