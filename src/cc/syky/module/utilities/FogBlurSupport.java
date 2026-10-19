package cc.syky.module.utilities;

import java.util.Map;

public final class FogBlurSupport {
   private static final Map<String, String> v1 = Map.ofEntries(
      Map.entry("syky.client.name", "syky"),
      Map.entry("whatsnew.heading", "What's new"),
      Map.entry("whatsnew.close", "Close"),
      Map.entry("whatsnew.discord", "Discord"),
      Map.entry("module.watermark.setting.secondColor.name", "Logo color"),
      Map.entry("module.hotkeys.setting.modules.name", "Module Display"),
      Map.entry("module.music_player.setting.playPause.name", "Play / Pause"),
      Map.entry("module.fps.setting.updateInterval.name", "Update every"),
      Map.entry("module.fps.setting.frameTime.name", "Frame time"),
      Map.entry("module.fps.setting.lowFps.name", "1% low"),
      Map.entry("module.fps.setting.groupDigits.name", "Group thousands"),
      Map.entry("module.fps.setting.fakeFps.name", "Fake FPS"),
      Map.entry("module.coords.setting.otherDimension.name", "Nether / Overworld"),
      Map.entry("module.game_clock.setting.format.name", "Format"),
      Map.entry("module.game_clock.setting.phase.name", "Day / night"),
      Map.entry("module.game_clock.setting.sleepTimer.name", "Sleep countdown"),
      Map.entry("module.game_clock.setting.showBefore.name", "Show before"),
      Map.entry("module.combo.setting.show.name", "Show"),
      Map.entry("module.combo.setting.label.name", "Show the word"),
      Map.entry("module.combo.setting.forgiveOneHit.name", "Ignore 1 enemy hit"),
      Map.entry("module.combo.setting.resetAfter.name", "Reset after"),
      Map.entry("module.shield_timer.setting.show.name", "Show"),
      Map.entry("module.durability_alert.setting.pieces.name", "Show"),
      Map.entry("module.durability_alert.setting.warnAt.name", "Warn at"),
      Map.entry("module.durability_alert.setting.readout.name", "Number"),
      Map.entry("module.item_pickups.setting.holdFor.name", "Show for"),
      Map.entry("module.item_pickups.setting.name.name", "Name"),
      Map.entry("module.target_hud.setting.winLose.name", "Win / Lose"),
      Map.entry("module.target_hud.setting.winLoseColors.name", "Win / Lose colors"),
      Map.entry("module.break_indicator.setting.label.name", "Show the word"),
      Map.entry("module.active_potion.setting.hiddenEffects.name", "Hide effects"),
      Map.entry("module.expiring_potion.setting.effects.name", "Effects"),
      Map.entry("module.expiring_potion.setting.warnAt.name", "Warn at"),
      Map.entry("module.expiring_potion.setting.blink.name", "Blink"),
      Map.entry("module.splash_accuracy.setting.holdFor.name", "Hold for"),
      Map.entry("module.inventory_hud.setting.hideWhenEmpty.name", "Hide when inventory is empty"),
      Map.entry("module.inventory_hud.setting.countSize.name", "Count size"),
      Map.entry("module.autosprint.name", "Sprint"),
      Map.entry("module.autosprint.description", "Keeps the sprint key held for you, so you never have to hold it down yourself."),
      Map.entry("module.togglesneak.name", "Toggle Sneak"),
      Map.entry("module.togglesneak.description", "Latches the sneak key: a tap keeps you crouched until the next one, so nothing has to stay held down."),
      Map.entry("module.targetesp.name", "Target Marker"),
      Map.entry("module.targetesp.setting.shape.name", "Style"),
      Map.entry("module.targetesp.setting.glowStrength.name", "Glow"),
      Map.entry("module.targetesp.setting.arrivalFrom.name", "Arrive from"),
      Map.entry("module.targetesp.setting.arrivalAdvanced.name", "Arrival, by hand"),
      Map.entry("module.targetesp.setting.arrivalTime.name", "Duration"),
      Map.entry("module.targetesp.setting.arrivalStagger.name", "Stagger"),
      Map.entry("module.targetesp.setting.arrivalDistance.name", "Distance"),
      Map.entry("module.targetesp.setting.arrivalSettle.name", "Settle"),
      Map.entry("module.targetesp.setting.arrivalSwing.name", "Swing"),
      Map.entry("module.targetesp.setting.arrivalSpin.name", "Spin"),
      Map.entry("module.targetesp.setting.arrivalLight.name", "Light up"),
      Map.entry("module.targetesp.setting.arrivalGlowLead.name", "Glow lead"),
      Map.entry("module.targetesp.setting.circleGlow.name", "Glow"),
      Map.entry("module.targetesp.setting.scanGlow.name", "Glow"),
      Map.entry("module.targetesp.setting.scanSpeed.name", "Speed"),
      Map.entry("module.targetesp.setting.glowAdvanced.name", "Glow, by hand"),
      Map.entry("module.targetesp.setting.glowHaloWide.name", "Halo width"),
      Map.entry("module.targetesp.setting.glowHaloNarrow.name", "Inner halo"),
      Map.entry("module.targetesp.setting.glowHaloAlpha.name", "Halo density"),
      Map.entry("module.targetesp.setting.glowShadeFloor.name", "Shade floor"),
      Map.entry("module.targetesp.setting.glowShadeGamma.name", "Shade curve"),
      Map.entry("module.targetesp.setting.orbitRadius.name", "Radius"),
      Map.entry("module.targetesp.setting.strands.name", "Trails"),
      Map.entry("module.targetesp.setting.trail.name", "Trail length"),
      Map.entry(
         "module.targetesp.description",
         "Marks the player or mob under your crosshair with light, in the style you pick, and holds it two seconds after you look away."
      ),
      Map.entry("module.saturation.name", "Food Saturation"),
      Map.entry(
         "module.saturation.description", "Draws the hidden saturation over the hunger bar, so you can see how long your food will hold and how fast you heal."
      ),
      Map.entry("module.fastgrass.name", "Fast Grass"),
      Map.entry(
         "module.fastgrass.description",
         "Wraps the top texture around the sides of grass, podzol, mycelium and nylium, and drops the overlay faces vanilla bakes."
      ),
      Map.entry("module.bushyleaves.name", "Bushy Leaves"),
      Map.entry(
         "module.bushyleaves.description",
         "Grows leafy tufts out of the edges of tree canopies, cut from your own leaf textures, so trees stop looking like stacks of cubes."
      ),
      Map.entry("module.fullbright.name", "FullBright"),
      Map.entry(
         "module.fullbright.description", "Removes darkness — flat full brightness, a dimmable custom level, or a night-vision look with no real potion."
      ),
      Map.entry("module.noshading.name", "No Shading"),
      Map.entry(
         "module.noshading.description",
         "Removes the darker sides of blocks, clouds and mobs so every face shows its true color. Can also drop corner shadows."
      ),
      Map.entry("module.noshading.setting.blocks.name", "Blocks & liquids"),
      Map.entry("module.noshading.setting.entities.name", "Mobs, players & items"),
      Map.entry("module.colorgrade.name", "Color Correction"),
      Map.entry(
         "module.colorgrade.description",
         "Grades the world like a photo — exposure, white balance, tone, split toning and vibrance — while the HUD keeps its true colors."
      ),
      Map.entry("module.colorgrade.setting.preset.name", "Look"),
      Map.entry("module.colorgrade.setting.curve.name", "Tone curve"),
      Map.entry("module.colorgrade.setting.pivot.name", "Curve pivot"),
      Map.entry("module.colorgrade.setting.splitStrength.name", "Strength"),
      Map.entry("module.colorgrade.setting.splitBalance.name", "Balance"),
      Map.entry("module.colorgrade.setting.shadowTint.name", "Shadow color"),
      Map.entry("module.colorgrade.setting.highlightTint.name", "Highlight color"),
      Map.entry("module.colorgrade.setting.grayscaleFilter.name", "Color filter"),
      Map.entry("module.motionblur.name", "Motion Blur"),
      Map.entry(
         "module.motionblur.description",
         "Smears the world along the camera's direction of travel, so close blocks streak more than far ones — the held item and the HUD stay sharp."
      ),
      Map.entry("module.particles.name", "Particles"),
      Map.entry(
         "module.particles.description",
         "Draws syky's own particles in the world — motes drifting in the air, a spray off whoever you hit, and a trail behind what you throw."
      ),
      Map.entry("module.particles.setting.hit.name", "Hit effect"),
      Map.entry("module.particles.setting.hitOnlyCrit.name", "Only crits"),
      Map.entry(
         "module.particles.setting.hitOnlyCrit.description",
         "Spray only on a critical hit — a fully charged swing taken while falling, not sprinting. Ordinary hits throw nothing."
      ),
      Map.entry("module.particles.setting.dustCount.name", "Count"),
      Map.entry("module.particles.setting.dustColor.name", "Color"),
      Map.entry("module.particles.setting.dustShape.name", "Shape"),
      Map.entry("module.particles.setting.dustSize.name", "Size"),
      Map.entry("module.particles.setting.dustRadius.name", "Radius"),
      Map.entry("module.particles.setting.dustSpeed.name", "Speed"),
      Map.entry("module.particles.setting.dustTwinkle.name", "Twinkle"),
      Map.entry("module.particles.setting.dustAura.name", "Aura"),
      Map.entry("module.particles.setting.hitCount.name", "Count"),
      Map.entry("module.particles.setting.hitColor.name", "Color"),
      Map.entry("module.particles.setting.hitShape.name", "Shape"),
      Map.entry("module.particles.setting.hitSize.name", "Size"),
      Map.entry("module.particles.setting.hitSpeed.name", "Speed"),
      Map.entry("module.particles.setting.hitGravity.name", "Gravity"),
      Map.entry("module.particles.setting.hitLife.name", "Lifetime"),
      Map.entry("module.particles.setting.hitSpread.name", "Spread"),
      Map.entry("module.particles.setting.hitAura.name", "Aura"),
      Map.entry("module.particles.setting.trailTargets.name", "Follow"),
      Map.entry("module.particles.setting.trailCount.name", "Count"),
      Map.entry("module.particles.setting.trailDensity.name", "Density"),
      Map.entry("module.particles.setting.trailColor.name", "Color"),
      Map.entry("module.particles.setting.trailShape.name", "Shape"),
      Map.entry("module.particles.setting.trailSize.name", "Size"),
      Map.entry("module.particles.setting.trailLife.name", "Length"),
      Map.entry("module.particles.setting.trailDrift.name", "Drift"),
      Map.entry("module.particles.setting.trailGravity.name", "Gravity"),
      Map.entry("module.particles.setting.trailSpread.name", "Spread"),
      Map.entry("module.particles.setting.trailAura.name", "Aura"),
      Map.entry("module.fog.name", "Custom Fog"),
      Map.entry(
         "module.fog.description",
         "Rewrites the world fog — off for a clear horizon, terrain only, or over the sky too — with your own color and near/far distance."
      ),
      Map.entry("module.fogblur.name", "Fog Blur"),
      Map.entry(
         "module.fogblur.description",
         "Softens the world past a distance you set — distant players blur along with the terrain. The held item and HUD stay sharp."
      ),
      Map.entry("module.wetsurfaces.name", "Wet Surfaces"),
      Map.entry(
         "module.wetsurfaces.description",
         "The world just after rain: surfaces darken, puddles gather on level ground and mirror the world, and raindrops ring across every wet surface."
      ),
      Map.entry("module.sky.name", "Custom Sky"),
      Map.entry(
         "module.sky.description",
         "Repaints the sky and can hide the sun, moon, stars or clouds, or replaces the whole sphere with your own picture — a panorama or a skybox."
      ),
      Map.entry("module.sky.setting.picture.name", "Overworld"),
      Map.entry(
         "module.sky.setting.picture.description",
         "Your own Overworld sky: a 2:1 panorama, an OptiFine pack's 3:2 sky or a 4:3 unfolded cube — the shape is read from the picture's proportions. PNG or JPG. Leave a dimension empty to keep its vanilla sky."
      ),
      Map.entry("module.sky.setting.pictureNether.name", "Nether"),
      Map.entry(
         "module.sky.setting.pictureNether.description",
         "Your own sky in the Nether, seen over the roof and through gaps in the walls. Leave it empty to keep the Nether as it is."
      ),
      Map.entry("module.sky.setting.pictureEnd.name", "End"),
      Map.entry("module.sky.setting.pictureEnd.description", "Your own sky in the End, in place of its dark swirl. Leave it empty to keep the End's own sky."),
      Map.entry("module.sky.setting.rotation.name", "Rotation"),
      Map.entry("module.sky.setting.rotation.description", "Turns the picture around you, to put its sunset or its mountains where you want them."),
      Map.entry("module.sky.setting.spin.name", "Spin"),
      Map.entry("module.sky.setting.spin.description", "Slowly turns the sky, in degrees a minute. Below zero turns it the other way."),
      Map.entry("module.sky.setting.followTime.name", "Day & night"),
      Map.entry("module.sky.setting.followTime.description", "Dims the picture at night and in rain, the way the vanilla sky darkens."),
      Map.entry("module.sky.setting.showSunMoon.name", "Sun & moon"),
      Map.entry("module.sky.setting.showSunMoon.description", "Keeps the vanilla sun and moon moving across your picture."),
      Map.entry("module.worldtint.name", "World Tint"),
      Map.entry(
         "module.worldtint.description",
         "Tints the world's light the way vanilla's night does, so caves stay dark and the HUD stays clean. Sky, fog and clouds keep their own colour."
      ),
      Map.entry("module.glint.name", "Custom Enchant Glint"),
      Map.entry(
         "module.glint.description",
         "Recolors the enchantment glint on items and armor for real, not as a tint — its color, brightness, pattern size, speed and angle are yours."
      ),
      Map.entry("module.hurtcolor.name", "Custom Hurt Color"),
      Map.entry(
         "module.hurtcolor.description",
         "Recolors the damage flash on players and mobs to a color whose alpha sets the strength — their armor and a fade-out are optional."
      ),
      Map.entry("module.hurtcolor.setting.colorArmor.name", "Includes armor"),
      Map.entry("module.healthring.name", "Health Advantage"),
      Map.entry(
         "module.healthring.description",
         "A glowing ring under a player's feet: green while your health and golden hearts match or beat theirs, red while they lead."
      ),
      Map.entry("module.healthring.setting.who.name", "Show for"),
      Map.entry("module.healthring.setting.arc.name", "Shrink with health"),
      Map.entry(
         "module.healthring.setting.arc.description",
         "The ring shortens as their health drops — a half ring at half health, its gap always on the far side from you."
      ),
      Map.entry("module.effectalerts.name", "Effect Alerts"),
      Map.entry(
         "module.effectalerts.description",
         "Flashes your screen edges when Strength runs out mid-fight, health runs low, a bad effect lands on you or you catch fire."
      ),
      Map.entry("module.effectalerts.setting.radius.name", "Flash radius"),
      Map.entry("module.effectalerts.setting.noStrength.name", "Strength ran out"),
      Map.entry(
         "module.effectalerts.setting.noStrength.description",
         "Flashes on every hit you land without Strength soon after having it, or with a weaker Strength than From level."
      ),
      Map.entry("module.effectalerts.setting.noStrengthColor.name", "Color"),
      Map.entry("module.effectalerts.setting.noStrengthLevel.name", "From level"),
      Map.entry(
         "module.effectalerts.setting.noStrengthLevel.description", "Hits with Strength under this level flash too, e.g. Strength II when you fight with III."
      ),
      Map.entry("module.effectalerts.setting.lowHealth.name", "Low health"),
      Map.entry(
         "module.effectalerts.setting.lowHealth.description",
         "Flashes when your health drops under the set number of hearts; staying on, the edge holds until you heal."
      ),
      Map.entry("module.effectalerts.setting.lowHealthColor.name", "Color"),
      Map.entry("module.effectalerts.setting.lowHealthHold.name", "Stay while active"),
      Map.entry("module.effectalerts.setting.lowHealthHold.description", "Keeps a softer edge for as long as it lasts, so you see it end too."),
      Map.entry("module.effectalerts.setting.lowHealthBelow.name", "Below"),
      Map.entry("module.effectalerts.setting.lowHealthBelow.description", "Health under this many hearts counts as low. Golden hearts are not counted."),
      Map.entry("module.effectalerts.setting.weakness.name", "Weakness"),
      Map.entry("module.effectalerts.setting.weakness.description", "Flashes when Weakness is put on you."),
      Map.entry("module.effectalerts.setting.weaknessColor.name", "Color"),
      Map.entry("module.effectalerts.setting.weaknessLevel.name", "From level"),
      Map.entry("module.effectalerts.setting.weaknessLevel.description", "Only this level of Weakness or stronger flashes."),
      Map.entry("module.effectalerts.setting.weaknessHold.name", "Stay while active"),
      Map.entry("module.effectalerts.setting.weaknessHold.description", "Keeps a softer edge for as long as it lasts, so you see it end too. "),
      Map.entry("module.effectalerts.setting.slowness.name", "Slowness"),
      Map.entry("module.effectalerts.setting.slowness.description", "Flashes when Slowness is put on you."),
      Map.entry("module.effectalerts.setting.slownessColor.name", "Color"),
      Map.entry("module.effectalerts.setting.slownessLevel.name", "From level"),
      Map.entry("module.effectalerts.setting.slownessLevel.description", "Only this level of Slowness or stronger flashes."),
      Map.entry("module.effectalerts.setting.slownessHold.name", "Stay while active"),
      Map.entry("module.effectalerts.setting.slownessHold.description", "Keeps a softer edge for as long as it lasts, so you see it end too. "),
      Map.entry("module.effectalerts.setting.poison.name", "Poison"),
      Map.entry("module.effectalerts.setting.poison.description", "Flashes when Poison is put on you."),
      Map.entry("module.effectalerts.setting.poisonColor.name", "Color"),
      Map.entry("module.effectalerts.setting.poisonLevel.name", "From level"),
      Map.entry("module.effectalerts.setting.poisonLevel.description", "Only this level of Poison or stronger flashes."),
      Map.entry("module.effectalerts.setting.poisonHold.name", "Stay while active"),
      Map.entry("module.effectalerts.setting.poisonHold.description", "Keeps a softer edge for as long as it lasts, so you see it end too. "),
      Map.entry("module.effectalerts.setting.burning.name", "On fire"),
      Map.entry("module.effectalerts.setting.burning.description", "Flashes when you catch fire without Fire Resistance. "),
      Map.entry("module.effectalerts.setting.burningColor.name", "Color"),
      Map.entry("module.effectalerts.setting.burningHold.name", "Stay while active"),
      Map.entry("module.effectalerts.setting.burningHold.description", "Keeps a softer edge for as long as it lasts, so you see it end too. "),
      Map.entry("module.effectalerts.setting.absorption.name", "Golden hearts"),
      Map.entry("module.effectalerts.setting.absorption.description", "Flashes when you gain golden hearts; staying on, the edge glows until they are gone."),
      Map.entry("module.effectalerts.setting.absorptionColor.name", "Color"),
      Map.entry("module.effectalerts.setting.absorptionHold.name", "Stay while active"),
      Map.entry("module.effectalerts.setting.absorptionHold.description", "Keeps a softer edge for as long as it lasts, so you see it end too. "),
      Map.entry("module.effectalerts.setting.hunger.name", "Hunger"),
      Map.entry("module.effectalerts.setting.hunger.description", "Flashes when Hunger is put on you."),
      Map.entry("module.effectalerts.setting.hungerColor.name", "Color"),
      Map.entry("module.effectalerts.setting.hungerLevel.name", "From level"),
      Map.entry("module.effectalerts.setting.hungerLevel.description", "Only this level of Hunger or stronger flashes."),
      Map.entry("module.effectalerts.setting.hungerHold.name", "Stay while active"),
      Map.entry("module.effectalerts.setting.hungerHold.description", "Keeps a softer edge for as long as it lasts, so you see it end too. "),
      Map.entry("module.effectalerts.setting.noStrengthMemory.name", "Watch for"),
      Map.entry("module.effectalerts.setting.noStrengthMemory.description", "How long after Strength wears off your hits still flash. "),
      Map.entry("module.time.name", "Time Changer"),
      Map.entry(
         "module.time.description",
         "Locks the sky, sun and lighting to a preset time of day, or any point on the slider — client-side only; the server's time is untouched."
      ),
      Map.entry("module.viewmodel.name", "ViewModel"),
      Map.entry(
         "module.viewmodel.description",
         "Moves, tilts and resizes the item in each hand independently — an empty hand keeps its vanilla pose, and the swing and equip animations still play."
      ),
      Map.entry("module.freelook.name", "Freelook"),
      Map.entry(
         "module.freelook.description",
         "Swings the camera around you in third person (F5) while your character keeps facing and moving as it was, so your aim never moves."
      ),
      Map.entry("module.thirdperson.name", "Third Person"),
      Map.entry(
         "module.thirdperson.description",
         "Holds Minecraft's own F5 view from the side you pick, and lets the wheel pull the camera in. Your character still turns with the mouse."
      ),
      Map.entry("module.chatcamera.name", "Chat Camera"),
      Map.entry(
         "module.chatcamera.description", "Drops the view into third person while the chat box is open, and hands back the view you had the moment it closes."
      ),
      Map.entry("module.selfnametag.name", "Self Nametag"),
      Map.entry(
         "module.selfnametag.description",
         "Draws your own nametag above your head in third person (F5) — the same tag every other player already sees over you."
      ),
      Map.entry("module.hidearmor.name", "Hide Armor"),
      Map.entry("module.hidearmor.description", "Hides the armor worn by players and mobs so their skins show through instead of the plates covering them."),
      Map.entry("module.itemphysic.name", "Item Physic"),
      Map.entry(
         "module.itemphysic.description", "Tumbles dropped items as they fall and lays them flat when they land, turning a floor of loot into readable piles."
      ),
      Map.entry("module.lootbeams.name", "Loot Beams"),
      Map.entry(
         "module.lootbeams.description",
         "Raises a column of light over every dropped item, coloured by its rarity, so loot on the floor is seen from across the room."
      ),
      Map.entry("module.lootbeams.setting.color.name", "Color"),
      Map.entry("module.lootbeams.setting.rarity.name", "Rarity colors"),
      Map.entry(
         "module.lootbeams.setting.rarity.description", "Uncommon items glow gold, rare ones cyan and epic ones violet; everything else takes the color above."
      ),
      Map.entry("module.lootbeams.setting.height.name", "Height"),
      Map.entry("module.aspectratio.name", "AspectRatio"),
      Map.entry("module.aspectratio.setting.hand.name", "Stretch the hand"),
      Map.entry(
         "module.aspectratio.description",
         "Stretches the world to a 4:3, 5:4 or 16:10 look on a widescreen monitor, so player models render wider — hit detection is untouched."
      ),
      Map.entry("module.zoom.name", "Zoom"),
      Map.entry(
         "module.zoom.description",
         "Zooms the world view and drops look sensitivity to match, so your aim stays precise — the wheel dials the magnification while zoomed."
      ),
      Map.entry("module.fov.name", "FOV"),
      Map.entry(
         "module.fov.description", "Overrides Minecraft's field-of-view setting with a fixed angle of your choice, taking priority so the two never stack."
      ),
      Map.entry("module.weather.name", "Weather Changer"),
      Map.entry("module.weather.description", "Forces the weather you see — clear, rain or thunder — client-side only; the server's real weather is untouched."),
      Map.entry("module.customcrosshair.name", "Custom Crosshair"),
      Map.entry(
         "module.customcrosshair.description",
         "Replaces the vanilla crosshair with your own shape, dot and color, and opens the gap on every swing so it tracks your attack cooldown."
      ),
      Map.entry("module.customcrosshair.setting.cooldownBar.name", "Cooldown bar"),
      Map.entry(
         "module.customcrosshair.setting.cooldownBar.description",
         "A bar under the crosshair that fills after every swing and is full the moment your next hit lands at full strength. Shows only with a sword, axe, spear, mace or trident in hand."
      ),
      Map.entry("module.customcrosshair.setting.barLength.name", "Length"),
      Map.entry("module.customcrosshair.setting.barThickness.name", "Thickness"),
      Map.entry("module.customcrosshair.setting.barOffset.name", "Distance below"),
      Map.entry("module.customcrosshair.setting.barColor.name", "Color"),
      Map.entry("module.customcrosshair.setting.barTrackColor.name", "Background"),
      Map.entry("module.customcrosshair.setting.barRounded.name", "Rounded ends"),
      Map.entry("module.customcrosshair.setting.barHideWhenReady.name", "Hide when ready"),
      Map.entry("module.customhitbox.name", "Custom Hitbox"),
      Map.entry(
         "module.customhitbox.description",
         "Draws an outline and fill on the hitboxes you pick, flipping to your reach color the moment a target is hittable. Walls still hide them."
      ),
      Map.entry("module.customhitbox.setting.shrink.name", "Shrink sides"),
      Map.entry(
         "module.customhitbox.setting.shrink.description",
         "Draws the box narrower than the real hitbox, height untouched. Hits and reach still use the full box; every on-target sign follows the narrow one."
      ),
      Map.entry("module.customhitbox.setting.hideEdgeHits.name", "Hide edge hits"),
      Map.entry(
         "module.customhitbox.setting.hideEdgeHits.description",
         "A hit on the real box but outside the narrow one shows nothing: no red flash, hit sounds, crits or combo. Damage, knockback and health stay real."
      ),
      Map.entry("module.blockoverlay.name", "Block Overlay"),
      Map.entry(
         "module.blockoverlay.description",
         "Replaces the vanilla block outline with your own color, thickness and a translucent fill — in Survival and Creative only."
      ),
      Map.entry("module.blockoverlay.setting.style.name", "Style"),
      Map.entry(
         "module.blockoverlay.setting.style.description",
         "Classic draws an outline and a fill. Brightness brightens the block itself instead, the way Bedrock Edition highlights it."
      ),
      Map.entry("module.blockoverlay.setting.brightColor.name", "Color"),
      Map.entry("module.blockoverlay.setting.brightness.name", "Strength"),
      Map.entry("module.blockoverlay.setting.brightness.description", "How much brighter the block gets. At the top it is twice as bright."),
      Map.entry("module.blockoverlay.setting.sideOnly.name", "Hovered side only"),
      Map.entry("module.blockoverlay.setting.sideOnly.description", "Outlines and fills just the side of the block you are looking at, not the whole block."),
      Map.entry("module.shield.name", "Custom Shield"),
      Map.entry(
         "module.shield.description",
         "Fades, lowers and shrinks your first-person shield so you can see past it, and colors a disabled one — yours and any other player's."
      ),
      Map.entry("module.fireoverlay.name", "Custom Fire Overlay"),
      Map.entry(
         "module.fireoverlay.description",
         "Pushes the fire that swallows your screen when you burn lower and recolors it at any opacity — the damage still lands."
      ),
      Map.entry("module.fireoverlay.setting.everywhere.name", "Everywhere"),
      Map.entry(
         "module.fireoverlay.setting.everywhere.description",
         "Colors every fire in the world — burning blocks, burning mobs — and not just your own screen. Repaints the texture, so it lands on a resource reload syky runs when you close this card."
      ),
      Map.entry("module.pumpkinoverlay.name", "Pumpkin Overlay"),
      Map.entry(
         "module.pumpkinoverlay.description",
         "Fades the blur a carved pumpkin paints over your screen, from vanilla down to nothing — you keep wearing it, endermen keep ignoring you."
      ),
      Map.entry("module.water.name", "Custom Water"),
      Map.entry(
         "module.water.description",
         "Recolors water to any color you pick and tints the underwater fog to match, or clears the fog and the blurry overlay to see underwater."
      ),
      Map.entry("module.raindrops.name", "Rain Drops"),
      Map.entry(
         "module.raindrops.description",
         "Rain on the camera: drops bend the world behind them, run down the glass in fits and starts and leave a trail of beads."
      ),
      Map.entry("module.raindrops.setting.mode.name", "Show"),
      Map.entry(
         "module.raindrops.setting.mode.description",
         "When it rains keeps the glass dry until rain would really be landing on you - the right weather, open sky above, eyes out of the water. Always keeps it wet everywhere."
      ),
      Map.entry("module.raindrops.setting.amount.name", "Drops"),
      Map.entry("module.raindrops.setting.size.name", "Size"),
      Map.entry("module.raindrops.setting.refraction.name", "Distortion"),
      Map.entry(
         "module.raindrops.setting.refraction.description",
         "How strongly a drop bends the world behind it. High fills every drop with a small upside-down picture of what is behind it."
      ),
      Map.entry("module.raindrops.setting.speed.name", "Speed"),
      Map.entry("module.raindrops.setting.trails.name", "Running Drops"),
      Map.entry("module.raindrops.setting.trails.description", "How much water runs down the glass. Each running drop leaves a trail of small beads behind it."),
      Map.entry("module.crystal.name", "Custom End Crystal"),
      Map.entry(
         "module.crystal.description", "Makes end crystals see-through and holds them still, so they stop blocking your view of the fight. Rendering only."
      ),
      Map.entry("module.tracker.name", "Tracker"),
      Map.entry(
         "module.tracker.description",
         "Throws a machine-vision field of brackets, tags and wires over whatever you are looking at, then cuts to somewhere else."
      ),
      Map.entry("module.totem.name", "Custom Totem Pop"),
      Map.entry(
         "module.totem.description",
         "Scales the totem the game throws across your screen on a pop, from hidden up to triple size, and flashes the edges in your color."
      ),
      Map.entry("module.removals.name", "Removals"),
      Map.entry(
         "module.removals.description",
         "Removes view bobbing, the hurt shake, dynamic FOV, screen overlays, pop-ups, shadows, stuck arrows and the particles you pick."
      ),
      Map.entry("module.removals.setting.vignette.description", "The dark rim around the screen's edges. The red world-border warning still shows."),
      Map.entry("module.removals.setting.toasts.name", "Pop-ups"),
      Map.entry(
         "module.removals.setting.toasts.description",
         "Advancement, recipe and tutorial pop-ups in the corner. Warnings, like a resource pack that failed to load, still show."
      ),
      Map.entry("module.removals.setting.stuckArrows.description", "Arrows and bee stingers drawn stuck in players' bodies."),
      Map.entry(
         "module.removals.setting.particles.description",
         "A pick hides its particles everywhere: Flame & Lava and Smoke also take torches and campfires, Portal & Pearl the portal glow and endermen."
      ),
      Map.entry("module.tiertagger.name", "Tier Tagger"),
      Map.entry(
         "module.tiertagger.description",
         "Shows each player's PvP tier from McTiers, qaztiers, Atiers, MyTiers and CISTiers in front of their name in the tab list and above their head."
      ),
      Map.entry("module.customsounds.name", "Custom Sounds"),
      Map.entry(
         "module.customsounds.description",
         "Replaces the hit, totem and explosion sounds with your own audio files — the melee clips fire on your own attacks only."
      ),
      Map.entry("module.inventorybackground.name", "Inventory Background"),
      Map.entry(
         "module.inventorybackground.description", "Plays your own GIF or photo behind the survival inventory, under your resource pack's own slots and frame."
      ),
      Map.entry("module.inventorybackground.setting.picture.name", "Picture"),
      Map.entry("module.inventorybackground.setting.picture.description", "A GIF, PNG or JPEG from your computer. Reset the row to take it away."),
      Map.entry("module.inventorybackground.setting.fit.name", "Fit"),
      Map.entry(
         "module.inventorybackground.setting.fit.description",
         "Fill covers the whole panel and crops the edges. Fit shows all of the picture. Stretch squeezes it onto the panel."
      ),
      Map.entry("module.inventorybackground.setting.opacity.name", "Opacity"),
      Map.entry("module.inventorybackground.setting.slotOpacity.name", "Slot opacity"),
      Map.entry(
         "module.inventorybackground.setting.slotOpacity.description",
         "How much of each slot's fill covers the picture. At 0% only the slot's outline is left."
      ),
      Map.entry("module.inventorybackground.setting.speed.name", "Speed"),
      Map.entry("module.inventorybackground.setting.speed.description", "How fast a GIF plays. 100% is the speed it was made at."),
      Map.entry("module.inventorybackground.setting.fillPlayerBox.name", "Behind player"),
      Map.entry(
         "module.inventorybackground.setting.fillPlayerBox.description",
         "Shows the picture in the box your character stands in, instead of the pack's dark backdrop."
      ),
      Map.entry("module.autorespawn.name", "Auto Respawn"),
      Map.entry(
         "module.autorespawn.description",
         "Skips the death screen and respawns you the instant you die, with no click — a server that holds you dead hands the screen back."
      ),
      Map.entry("module.safeinteraction.name", "Safe Interaction"),
      Map.entry(
         "module.safeinteraction.description",
         "Drops a left-click that would hurt a tamed pet or a villager — feeding, breeding and trading still work, and the click never reaches the server."
      ),
      Map.entry("module.durabilityguard.name", "Durability Guard"),
      Map.entry(
         "module.durabilityguard.description", "Stops a click that would break the tool, weapon or bow in your hand, keeping the durability reserve you set."
      ),
      Map.entry("module.durabilityguard.notice", "Durability reserve reached"),
      Map.entry("module._server.refused", "is off on"),
      Map.entry("module.dropguard.name", "Drop Guard"),
      Map.entry(
         "module.dropguard.description",
         "Locks the hotbar slots you pick against the drop key, so a misclick never throws your sword away mid-fight — the inventory still drops it."
      ),
      Map.entry("module.dropguard.setting.slots.name", "Locked slots"),
      Map.entry("module.dropguard.notice", "Slot locked by Drop Guard"),
      Map.entry("module.streamermode.name", "Streamer Mode"),
      Map.entry(
         "module.streamermode.description",
         "Masks your nickname, skin, coords and server IP, and hides the bedrock, ores, biome colours and clouds a seed cracker reads."
      ),
      Map.entry("module.streamermode.setting.hideBedrock.description", "Draws bedrock as the rock around it, so its seed-made pattern cannot be read."),
      Map.entry("module.streamermode.setting.hideRotation.description", "Stops block textures turning with their position, which pins down coordinates."),
      Map.entry("module.streamermode.setting.hideOres.description", "Draws ores as the rock they sit in."),
      Map.entry("module.streamermode.setting.hideStoneVariants.description", "Draws andesite, granite, diorite and gravel as stone, and tuff as deepslate."),
      Map.entry("module.streamermode.setting.hideBiomeColors.description", "Gives grass, leaves and water one colour everywhere, so the biome cannot be told."),
      Map.entry(
         "module.streamermode.setting.hideClouds.description", "Clouds repeat over the world, so their shape in a screenshot narrows down where you are."
      ),
      Map.entry("module.shulkerpreview.name", "Shulker Preview"),
      Map.entry(
         "module.shulkerpreview.description",
         "Draws the contents of the shulker box under your cursor as an item grid, counts and durability bars included, so you never place it down."
      ),
      Map.entry("module.borderless.name", "Borderless Fullscreen"),
      Map.entry(
         "module.borderless.description", "Turns fullscreen into a borderless window at your desktop resolution, so Alt-Tab to Discord or OBS is instant."
      ),
      Map.entry("module.reconnectbutton.name", "Reconnect Button"),
      Map.entry(
         "module.reconnectbutton.description", "Adds a Reconnect button that joins the last server again, on the disconnect screen and in the pause menu."
      ),
      Map.entry("module.reconnectbutton.setting.disconnectScreen.name", "On disconnect screen"),
      Map.entry("module.reconnectbutton.setting.pauseMenu.name", "In pause menu"),
      Map.entry("module.pvpleaveconfirm.name", "PvP Leave Confirm"),
      Map.entry(
         "module.pvpleaveconfirm.description",
         "Asks before Disconnect takes you off a server whose boss bar says you are still in PvP combat, and makes you type /hub twice."
      ),
      Map.entry("module.pvpleaveconfirm.dialog.title", "PvP mode is active"),
      Map.entry(
         "module.pvpleaveconfirm.dialog.message",
         "The server still has you in combat. Leaving now counts as combat logging, and many servers kill you for it and drop your items."
      ),
      Map.entry("module.pvpleaveconfirm.dialog.leave", "Leave"),
      Map.entry("module.pvpleaveconfirm.dialog.cancel", "Cancel"),
      Map.entry("module.pvpleaveconfirm.command.held", "Leaving now counts as combat logging. Send {command} again within 10 seconds to leave anyway."),
      Map.entry("module.slothighlight.name", "Slot Highlight"),
      Map.entry(
         "module.slothighlight.description",
         "Tints the inventory slot behind each fight item you care about — totems, pearls, potions, anchors — in its own colour."
      ),
      Map.entry("module.slothighlight.setting.style.name", "Tint"),
      Map.entry("module.slothighlight.setting.style.description", "Behind item colours the slot around the item. Over item colours the item itself too."),
      Map.entry("module.slothighlight.setting.goldenApple.name", "Golden Apple"),
      Map.entry("module.slothighlight.setting.enchantedGoldenApple.name", "Enchanted Golden Apple"),
      Map.entry("module.slothighlight.setting.healingPotion.name", "Healing Potion"),
      Map.entry("module.slothighlight.setting.strengthPotion.name", "Strength Potion"),
      Map.entry("module.slothighlight.setting.speedPotion.name", "Speed Potion"),
      Map.entry("module.slothighlight.setting.xpBottle.name", "XP Bottle"),
      Map.entry("module.slothighlight.setting.totem.name", "Totem"),
      Map.entry("module.slothighlight.setting.endCrystal.name", "End Crystal"),
      Map.entry("module.slothighlight.setting.obsidian.name", "Obsidian"),
      Map.entry("module.slothighlight.setting.respawnAnchor.name", "Respawn Anchor"),
      Map.entry("module.slothighlight.setting.glowstone.name", "Glowstone"),
      Map.entry("module.slothighlight.setting.crossbow.name", "Crossbow"),
      Map.entry("module.slothighlight.setting.mace.name", "Mace"),
      Map.entry("module.slothighlight.setting.firework.name", "Firework"),
      Map.entry("module.slothighlight.setting.elytra.name", "Elytra"),
      Map.entry("module.slothighlight.setting.windCharge.name", "Wind Charge"),
      Map.entry("module.slothighlight.setting.cobweb.name", "Cobweb"),
      Map.entry("module.slothighlight.setting.enderPearl.name", "Ender Pearl"),
      Map.entry("module.slothighlight.setting.chorusFruit.name", "Chorus Fruit"),
      Map.entry("module.item_counter.setting.goldenApple.name", "Golden Apple"),
      Map.entry("module.item_counter.setting.enchantedGoldenApple.name", "Enchanted Golden Apple"),
      Map.entry("module.item_counter.setting.healingPotion.name", "Healing Potion"),
      Map.entry("module.item_counter.setting.strengthPotion.name", "Strength Potion"),
      Map.entry("module.item_counter.setting.speedPotion.name", "Speed Potion"),
      Map.entry("module.item_counter.setting.xpBottle.name", "XP Bottle"),
      Map.entry("module.item_counter.setting.totem.name", "Totem"),
      Map.entry("module.item_counter.setting.endCrystal.name", "End Crystal"),
      Map.entry("module.item_counter.setting.obsidian.name", "Obsidian"),
      Map.entry("module.item_counter.setting.respawnAnchor.name", "Respawn Anchor"),
      Map.entry("module.item_counter.setting.glowstone.name", "Glowstone"),
      Map.entry("module.item_counter.setting.arrow.name", "Arrow"),
      Map.entry("module.item_counter.setting.firework.name", "Firework"),
      Map.entry("module.item_counter.setting.windCharge.name", "Wind Charge"),
      Map.entry("module.item_counter.setting.cobweb.name", "Cobweb"),
      Map.entry("module.item_counter.setting.enderPearl.name", "Ender Pearl"),
      Map.entry("module.item_counter.setting.chorusFruit.name", "Chorus Fruit"),
      Map.entry("module.healthindicator.name", "Health Indicator"),
      Map.entry(
         "module.healthindicator.description",
         "Draws a vanilla heart row over players and mobs, gold absorption hearts and the armor bar included, so you know what a target can still take."
      ),
      Map.entry("module.healthindicator.setting.goldFillsEmpty.name", "Gold hearts fill gaps"),
      Map.entry(
         "module.healthindicator.setting.goldFillsEmpty.description",
         "Absorption hearts take the empty red slots first, so someone at half a heart with a lot of gold does not look nearly dead. Gold that does not fit goes on top."
      ),
      Map.entry("module.customhearts.name", "Custom Hearts"),
      Map.entry(
         "module.customhearts.description",
         "Recolours your health and golden hearts above the hotbar, and switches off the poison, wither and freeze looks one by one."
      ),
      Map.entry("module.customhearts.setting.customHeartColor.name", "Heart color"),
      Map.entry("module.customhearts.setting.heartColor.name", "Heart color"),
      Map.entry("module.customhearts.setting.customGoldColor.name", "Golden heart color"),
      Map.entry("module.customhearts.setting.goldColor.name", "Golden heart color"),
      Map.entry("module.customhearts.setting.poison.name", "Poison hearts"),
      Map.entry("module.customhearts.setting.poison.description", "Turns your hearts green while you are poisoned. Off keeps them their usual colour."),
      Map.entry("module.customhearts.setting.wither.name", "Wither hearts"),
      Map.entry(
         "module.customhearts.setting.wither.description", "Turns your hearts black while you have the Wither effect. Off keeps them their usual colour."
      ),
      Map.entry("module.customhearts.setting.frozen.name", "Frozen hearts"),
      Map.entry(
         "module.customhearts.setting.frozen.description", "Turns your hearts icy blue while you freeze in powder snow. Off keeps them their usual colour."
      ),
      Map.entry("module.customhearts.setting.damageFlash.name", "Flash on damage"),
      Map.entry("module.customhearts.setting.damageFlash.description", "Flashes the heart row white for a moment when you take damage or heal."),
      Map.entry("module.customhearts.setting.lowHealthShake.name", "Shake at low health"),
      Map.entry("module.customhearts.setting.lowHealthShake.description", "Shakes the heart row while you are down to two hearts or less."),
      Map.entry("module.customhearts.setting.regenWave.name", "Regeneration wave"),
      Map.entry("module.customhearts.setting.regenWave.description", "Lifts one heart after another along the row while Regeneration heals you."),
      Map.entry("module.tnttimer.name", "TNT Timer"),
      Map.entry(
         "module.tnttimer.description", "Counts the fuse down over every primed TNT around you, fading the label to a warning colour as the blast closes in."
      ),
      Map.entry("module.lightoverlay.name", "Light Overlay"),
      Map.entry(
         "module.lightoverlay.description",
         "Paints the blocks around you that monsters could spawn on, and shows where a held torch lights them all with the fewest placed."
      ),
      Map.entry("module.lightoverlay.setting.fromBelow.name", "Show from below"),
      Map.entry(
         "module.lightoverlay.setting.fromBelow.description",
         "A short fade hangs down from the edges of painted blocks, so you notice them on roofs and ledges above you."
      ),
      Map.entry("module.lightoverlay.setting.range.description", "How far around you blocks are checked, in blocks."),
      Map.entry(
         "module.lightoverlay.setting.torchHints.description",
         "While you hold a torch or any other light, marks the fewest spots that light every painted block."
      ),
      Map.entry(
         "module.lightoverlay.setting.placePreview.description",
         "While you aim a torch or any other light at where it would go, turns the painted blocks it would light to the preview colour."
      ),
      Map.entry("module.chunkborders.name", "Chunk Borders"),
      Map.entry(
         "module.chunkborders.description", "Outlines the chunk you stand in, through walls too, so farms and builds line up with chunk borders exactly."
      ),
      Map.entry("module.chunkborders.setting.throughWalls.description", "Shows the border where blocks hide it too, fainter than where you can see it."),
      Map.entry("module.pingtags.name", "Ping Tags"),
      Map.entry(
         "module.pingtags.description",
         "Stacks each nearby player's tab-list ping over their nametag as a second label, graded from a good to a bad colour as it rises."
      ),
      Map.entry("module.focusfade.name", "Focus Fade"),
      Map.entry(
         "module.focusfade.description",
         "Fades the game's volume down smoothly while the window is unfocused and lifts it back when you return, by however much you set."
      ),
      Map.entry("module.hotbarkeys.name", "Hotbar Keys"),
      Map.entry(
         "module.hotbarkeys.description",
         "Writes the key that selects each hotbar slot into the slot, so a hotbar rebound off 1-9 still tells you which key holds what."
      ),
      Map.entry("module.chatreveal.name", "Chat Reveal"),
      Map.entry(
         "module.chatreveal.description",
         "Keeps the faded chat lines on screen at the height the chat box opens to, and puts the backlog under your scroll wheel."
      ),
      Map.entry("module.chatreveal.setting.scroll.name", "Scroll with the wheel"),
      Map.entry("module.chathistory.name", "Infinite Chat History"),
      Map.entry("module.chathistory.description", "Keeps the last 20,000 chat lines to scroll back through instead of the last 100."),
      Map.entry("module.capsfix.name", "Caps Fix"),
      Map.entry(
         "module.capsfix.description", "Takes the shouting out of a message you typed in caps lock, and leaves short acronyms, tags and nicknames alone."
      ),
      Map.entry("module.commandfix.name", "Command Fix"),
      Map.entry(
         "module.commandfix.description", "Fixes a command you typed without switching your keyboard back to English, so it runs instead of going to chat."
      ),
      Map.entry("module.chatstack.name", "Chat Stack"),
      Map.entry(
         "module.chatstack.description",
         "Folds a message repeated straight after itself back into the copy above it, counting them in grey instead of restacking the chat."
      ),
      Map.entry("module.chatping.name", "Chat Ping"),
      Map.entry(
         "module.chatping.description",
         "Plays a sound, underlines your name and highlights the line when someone mentions you in chat, and rings for a private message as well."
      ),
      Map.entry("module.chatping.setting.tone.name", "Tone"),
      Map.entry("module.chatping.setting.highlight.name", "Highlight the line"),
      Map.entry(
         "module.chatping.setting.highlight.description",
         "Tints the background of a message that mentions you, even with the chat background turned off in Minecraft's options."
      ),
      Map.entry("module.chatping.setting.volume.name", "Volume"),
      Map.entry("module.chatping.setting.underline.name", "Underline your name"),
      Map.entry("module.chatping.setting.recolor.name", "Color your name"),
      Map.entry("module.chatping.setting.whispers.name", "Ring on private messages"),
      Map.entry("module.chatping.setting.notify.name", "Desktop notification"),
      Map.entry("module.chatping.setting.notify.description", "With the game in the background, a mention or private message also shows a system notification."),
      Map.entry("module.chatping.setting.whispers.description", "A whisper sent to you rings even when it does not say your name."),
      Map.entry("module.chatping.setting.flash.name", "Flash the taskbar"),
      Map.entry("module.chatping.setting.flash.description", "Blinks the game's taskbar button when you are mentioned while another window is in front."),
      Map.entry("module.chatheads.name", "Chat Heads"),
      Map.entry("module.chatheads.description", "Draws the skin face of whoever sent each chat message beside it, so you see who is talking at a glance."),
      Map.entry("module._gui.setting.discord.name", "DiscordRPC"),
      Map.entry("module._gui.setting.uiScale.name", "Interface scale"),
      Map.entry("module._gui.setting.uiScale.description", "Size of the menu, its popups and the other syky windows. The HUD keeps its own scale."),
      Map.entry("module._gui.setting.theme.description", "The menu's colors. Off, the menu goes back to its stock colors and keeps yours for later."),
      Map.entry("module._gui.setting.themeMode.description", "Simple is four colors and the rest made from them. Full gives every part of the menu its own."),
      Map.entry("module._gui.setting.themeAccent.name", "Color 1"),
      Map.entry("module._gui.setting.themeAccent.description", "Switches that are on."),
      Map.entry("module._gui.setting.themeHighlight.name", "Color 2"),
      Map.entry("module._gui.setting.themeHighlight.description", "The sidebar: the logo, the open page's icon and the plate under it."),
      Map.entry("module._gui.setting.themeOpenPage.name", "Open page"),
      Map.entry("module._gui.setting.themeOpenPage.description", "The name of the page you are on. Follows Color 2 until you pick it yourself."),
      Map.entry("module._gui.setting.themeBackground.name", "Background"),
      Map.entry("module._gui.setting.themeBackground.description", "The menu's glass. Its opacity sets how much of the world shows through."),
      Map.entry("module._gui.setting.themeCard.name", "Cards"),
      Map.entry(
         "module._gui.setting.themeCard.description",
         "The groups of modules, the header buttons and the search box. Follows Background until you pick it yourself."
      ),
      Map.entry("module._gui.setting.themeText.name", "Text & Icons"),
      Map.entry("module._gui.setting.themeText.description", "Module names and every icon. Headings and dimmed text follow it in their own shades."),
      Map.entry("module._gui.setting.themeSidebarText.name", "Sidebar text"),
      Map.entry("module._gui.setting.themeSidebarText.description", "The names of the pages you are not on. Follows Text & Icons until you pick it yourself."),
      Map.entry("module._gui.setting.themeIcons.name", "Icons"),
      Map.entry("module._gui.setting.themeIcons.description", "Every icon in the menu. Follows Text & Icons until you pick it yourself."),
      Map.entry("module._gui.setting.themeLine.name", "Lines"),
      Map.entry("module._gui.setting.themeLine.description", "Borders, dividers and the light a row takes under the cursor."),
      Map.entry("module._gui.setting.loading.name", "Loading screen"),
      Map.entry(
         "module._gui.setting.loading.description", "Puts syky's mark on the screen the game loads behind, in place of Mojang's. Unaffected by resource packs."
      ),
      Map.entry("module._gui.setting.blurBleed.name", "Surrounding colors"),
      Map.entry(
         "module._gui.setting.blurBleed.description",
         "Lets the colors around a panel or a HUD element seep into the edges of its blur, as they used to. Off, the blur shows only what is right behind it."
      ),
      Map.entry("module._gui.setting.loadingBackground.name", "Background"),
      Map.entry("module._gui.setting.loadingText.name", "Foreground"),
      Map.entry("module._gui.setting.loadingText.description", "Colours the mark, the wordmark and the progress bar."),
      Map.entry("module._waypoint.setting.showInNether.name", "Show in Nether"),
      Map.entry("module._waypoint.setting.showInOverworld.name", "Show in Overworld"),
      Map.entry("module._waypoint.setting.alwaysLabel.name", "Always show name"),
      Map.entry("module._waypoint.setting.customSize.name", "Custom size"),
      Map.entry("module._waypoint.setting.fillOpacity.name", "Filled opacity"),
      Map.entry("module._waypoint.setting.outlineThickness.name", "Outline thickness"),
      Map.entry("module._waypoint.setting.markerHeight.name", "Marker height"),
      Map.entry("module._waypoints.setting.allWorlds.name", "Show all worlds"),
      Map.entry("module._waypoints.setting.deathPoints.name", "Death waypoints"),
      Map.entry("module._waypoints.setting.removeReachedDeaths.name", "Remove when reached"),
      Map.entry("module._accounts.setting.sortBy.name", "Sort by"),
      Map.entry("module._accounts.setting.besideName.name", "Beside name"),
      Map.entry("module._accounts.setting.splitByType.name", "Split by type"),
      Map.entry("module._accounts.setting.rememberAccount.name", "Remember account"),
      Map.entry("module._socials.setting.showServerTo.name", "Show my server to"),
      Map.entry("module._socials.setting.friendRequestsFrom.name", "Friend requests from")
   );

   private FogBlurSupport() {
   }

   public static String v1(String var0, String var1) {
      return var0 != null && !var0.isEmpty() ? v1.getOrDefault(var0, var1) : var1;
   }

   public static boolean v1(String var0) {
      return var0 != null && v1.containsKey(var0);
   }
}
