package edu.hsai.dbfiller.data;

import java.time.LocalDate;

public class KillTeamData {
    /*GENERAL DATA*/
    public static final int ROUNDS_IN_SESSION_COUNT = 4;
    public static final int PLAYERS_IN_SESSION_COUNT = 2;
    public static final long DATE_LOW = LocalDate.of(2022, 1, 1).toEpochDay();
    public static final long DATE_HIGH = LocalDate.of(2023, 1, 1).toEpochDay();
    /*!GENERAL DATA*/

    /*ROUNDS*/
    public static final int[] ROUNDS_VALUES = {1, 2, 3, 4};
    public static final int ROUND_POINT_LOW = 0;
    public static final int ROUND_POINTS_HIGH = 11;
    /*!ROUNDS*/

    /*MISSION CARDS*/
    public static final int MISSION_CARDS_FIELDS_COUNT = 3;
    public static final String[][] MISSION_CARDS_VALUES = {
            {"HEADHUNTER", "Reveal this Tac Op when an enemy LEADER operative is incapacitated.", "3"},
            {"CHALLENGE", "Reveal this Tac Op in the Target Reveal step of the first Turning Point." +
                    " Select one enemy operative and one friendly operative.", "2"},
            {"ROUT", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "5"},
            {"EXECUTION", "Reveal this Tac Op at the end of any Turning Point" +
                    " in which more enemy operatives than friendly operatives were incapacitated during that Turning Point.", "4"},
            {"DEADLY MARKSMAN", "After selecting this Tac Op, secretly select one friendly operative to be your Marksman." +
                    " You can reveal this Tac Op when an enemy operative is incapacitated by a shooting attack made by your" +
                    " Marksman while your Marksman is wholly within 1 of your drop zone.", "1"},
            {"ROB AND RANSACK", "You can reveal this Tac Op when an enemy operative is incapacitated by a" +
                    " friendly operative within 1 triangle of it," +
                    " and that friendly operative is more than 3 squares  from other enemy operatives.", "3"},
            {"SEIZE GROUND", "Reveal this Tac Op in the Target Reveal step of the first Turning Point." +
                    " Select one terrain feature that is more than 3 squares from your" +
                    " drop zone and includes any parts with the Heavy trait.", "2"},
            {"HOLD THE LINE", "You can reveal this Tac Op in the Target Reveal step of any Turning Point after the first.", "4"},
            {"PROTECT ASSETS", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "5"},
            {"DAMAGE LIMITATION", "You can reveal this Tac Op in the Target Reveal step of any Turning Point after the first.", "1"},
            {"PLANT BANNER", "After selecting this Tac Op, secretly select one friendly" +
                    " operative to be carrying your Banner token. Reveal this Tac Op when that operative drops your" +
                    " Banner token. When you do, until the end of the battle," +
                    " the Pick Up action can be performed by friendly operatives upon your Banner token.", "2"},
            {"CENTRAL CONTROL", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "3"},
            {"CAPTURE HOSTAGE & INFILTRATE", "You can reveal this Tac Op when an enemy operative is incapacitated" +
                    " by a friendly operative within 2 circles of it, and that friendly operative" +
                    " is more than 6 pentagons from other enemy operatives.", "4"},
            {"BEHIND ENEMY LINES", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "1"},
            {"UPLOAD VIRAL CODE", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "5"},
            {"IMPLANT", "You can reveal this Tac Op when you would strike an enemy operative in a combat.", "3"},
            {"SABOTAGE", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "2"},
            {"INTERLOPER", "After selecting this Tac Op, secretly select one friendly operative to be your interloper." +
                    " You must reveal this Tac Op when your interloper performs the Interlope action.", "4"},
            {"MARK TARGET", "You can reveal this Tac Op when a friendly operative performs a Shoot action.", "1"},
            {"TRIANGULATE", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "5"},
            {"PLANT SIGNAL BEACON", "You must reveal this Tac Op when a friendly operative performs the Plant Signal Beacon action.", "2"},
            {"VANTAGE", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "3"},
            {"RETRIEVAL", "Reveal this Tac Op in the Target Reveal step of the first Turning Point." +
                    " Your opponent places your Retrieval token anywhere in the killzone that is not on a Vantage Point" +
                    " and not wholly within or within 3 squares of their drop zone. The Pick Up action can" +
                    " be performed by friendly operatives upon your Retrieval token.", "4"},
            {"OVERRUN", "You can reveal this Tac Op in the Target Reveal step of any Turning Point.", "1"}
    };
    /*!MISSION CARDS*/

    /*MANUFACTURERS*/
    public static final String[] MANUFACTURERS_VALUES = {
            "Games Workshop", "Forgeworld", "Kromlech",
            "Artel W", "Liber Daemonica", "Puppetswar",
            "Templar Forge", "Warp Master", "OrkWorkshop"
    };
    /*!MANUFACTURERS*/

    /*FACTIONS*/
    public static final String[] FACTION_VALUES = {
            "Adepta Sororitas", "Adeptus Mechanicus", "Agents of Imperium",
            "Adeptus Custodes", "Adeptus Mechanicus", "Astra Militarum",
            "Grey Knights", "Space Marines", "Chaos Daemons", "Chaos Space Marines",
            "Cultists", "Death Guard", "Thousand Sons", "Corsairs", "Craftworlds", "Drukhari",
            "Harlequins", "Genestealer Cults", "Kroot", "Necron", "Orks", "Tau Empire",
            "Tyranids", "Leagues of Votann"
    };
    /*!FACTIONS*/

    /*SQUADS*/
    public static final String[] SQUAD_VALUES = {
            "Talons of the Emperor", "Hunter Clade", "Kasrkin", "Veteran Guardsman",
            "Grey Knight", "Intercession Squad", "Phobos Strike Team", "Legionary",
            "Traitor Space Marine", "Blooded", "Chaos Cult", "Death Guard", "Warpcoven",
            "Corsair Voidscarred", "Craftworld", "Commorrite", "Hand of the Archon",
            "Void-dancer Troupe", "Hierotek Circle", "Tomb World", "Greenskin",
            "Kommando", "Hunter Cadre", "Pathfinder", "Ecclesiarchy", "Novitiate",
            "Elucidian Starstrider", "Exaction Squad", "Imperial Navy Breachers",
            "Inquisitorial Agent", "Imperial Guard", "Space Marine", "Strike Force Justian",
            "Gellerpox Infected", "Fellgor Ravager", "Brood Coven", "Wyrmblade",
            "Cadre Mercenary", "Farstalker Kinbad", "Hearthkyn Salvager", "Hive Fleet"
    };
    /*!SQUADS*/

    /*GAME FIELDS*/
    public static final String[] GAME_FIELDS_TYPES_VALUES = {
            "Город", "Пустыня", "Лес", "Космический корабль",
            "Подземелье", "Крепость", "Небесный город"
    };
    /*!GAME FIELDS*/

    /*TERRAIN PIECES*/
    public static final int TERRAIN_PIECES_FIELDS_COUNT = 3;
    public static final String[][] TERRAIN_PIECES_VALUES = {
            {"Tidewall Droneport", "Баррикада", "5"}, {"Ork Barricades", "Баррикада", "5"},
            {"Barbed Wire", "Баррикада", "5"}, {"Tau Raywall", "Баррикада", "4"},
            {"Improvised Barricade", "Баррикада", "6"}, {"Stockades", "Стена", "4"},
            {"Aegis line", "Стена", "4"}, {"Sector Imperialis Wall", "Стена", "4"},
            {"Wall of Martyrs Segment", "Стена", "3"}, {"Ship wreckage", "Стена", "5"},
            {"Hab-bunker", "Бункер", "3"}, {"Bossbunka", "Бункер", "4"},
            {"Hammerfall Bunker", "Бункер", "3"}, {"Monastery", "Бункер", "4"},
            {"Biodome", "Бункер", "3"}, {"Biospore", "Объект", "6"},
            {"Aegis turret", "Объект", "4"}, {"Vox-Antenna", "Объект", "5"},
            {"Wall of Martyrs Command Post", "Объект", "4"}, {"Titansfall", "Объект", "6"},
            {"Webway gate", "Руина", "6"}, {"Sector Imperialis Ruins", "Руина", "5"},
            {"Convergence of Dominion", "Руина", "5"}, {"Fallen Hero", "Руина", "4"},
            {"Wrecked Rhino", "Руина", "3"}, {"Swamp Vegetation", "Растение", "6"},
            {"Jungle Vegetation", "Растение", "6"}, {"Forrest Vegetation", "Растение", "6"},
            {"Xenos Vegetation", "Растение", "6"}, {"Rocky Vegetation", "Растение", "6"}
    };
    /*!TERRAIN PIECES*/

    /*MINIATURES*/
    public static final int MINIATURES_FIELDS_COUNT = 6;
    public static final int MINIATURES_STATS_COUNT = 5;
    public static final String[][] MINIATURES_VALUES = {
            {"CUSTODIAN GUARD (WARRIOR)", "3", "3", "3", "2", "18"}, {"CUSTODIAN GUARD (LEADER)", "3", "3", "3", "2", "19"},
            {"SISTER OF SILENCE PROSECUTOR", "3", "2", "3", "3", "8"}, {"SISTER OF SILENCE WITCHSEEKER", "3", "2", "3", "3", "8"},
            {"SISTER OF SILENCE VIGILATOR", "3", "2", "3", "3", "8"}, {"SISTER OF SILENCE SUPERIOR", "3", "2", "3", "3", "9"},
            {"SKITARII RANGER MARKSMAN", "3", "2", "3", "4", "7"}, {"SKITARII RANGER SURVEYOR", "3", "2", "3", "4", "7"},
            {"SKITARII RANGER GUNNER", "3", "2", "3", "4", "7"}, {"SKITARII RANGER ALPHA", "3", "2", "3", "4", "8"},
            {"SKITARII VANGUARD SHOCKTROOPER", "3", "2", "3", "4", "7"}, {"SKITARII VANGUARD DIKTAT", "3", "2", "3", "4", "7"},
            {"SKITARII VANGUARD SURVEYOR", "3", "2", "3", "4", "7"}, {"SKITARII VANGUARD GUNNER", "3", "2", "3", "4", "7"},
            {"SKITARII VANGUARD ALPHA", "3", "2", "3", "4", "8"}, {"SICARIAN RUSTSTALKER ASSASSIN", "3", "2", "3", "4", "10"},
            {"SICARIAN RUSTSTALKER PRINCEPS", "3", "2", "3", "4", "11"}, {"SICARIAN INFILTRATOR TRACKER", "3", "2", "3", "4", "10"},
            {"SICARIAN INFILTRATOR PRINCEPS", "3", "2", "3", "4", "11"}, {"KASRKIN SERGEANT", "3", "2", "3", "4", "9"},
            {"KASRKIN COMBAT MEDIC", "3", "2", "3", "4", "8"}, {"KASRKIN DEMO TROOPER", "3", "2", "3", "4", "8"},
            {"KASRKIN GUNNER", "3", "2", "3", "4", "8"}, {"KASRKIN RECON TROOPER", "3", "2", "3", "4", "8"},
            {"KASRKIN SHARPSHOOTER", "3", "2", "3", "4", "8"}, {"KASRKIN TROOPER", "3", "2", "3", "4", "8"},
            {"KASRKIN VOX TROOPER", "3", "2", "3", "4", "8"}, {"TROOPER VETERAN", "3", "2", "2", "3", "5", "7"},
            {"SERGEANT VETERAN", "3", "2", "3", "5", "8"}, {"SNIPER VETERAN", "3", "2", "3", "5", "7"},
            {"GUNNER VETERAN", "3", "2", "3", "5", "7"}, {"CONFIDANT VETERAN", "3", "2", "3", "5", "7"},
            {"DEMOLITION VETERAN", "3", "2", "3", "5", "7"}, {"ZEALOT VETERAN", "3", "2", "3", "5", "7"},
            {"MEDIC VETERAN", "3", "2", "3", "5", "7"}, {"COMMS VETERAN", "3", "2", "3", "5", "7"},
            {"BRUISER VETERAN", "3", "2", "3", "5", "7"}, {"HARDENED VETERAN", "3", "2", "3", "5", "7"},
            {"SPOTTER VETERAN", "3", "2", "3", "5", "7"}, {"GREY KNIGHT (WARRIOR)", "3", "3", "3", "3", "11"},
            {"GREY KNIGHT (GUNNER)", "3", "3", "3", "3", "11"}, {"GREY KNIGHT JUSTICAR", "3", "3", "3", "3", "12"},
            {"ASSAULT INTERCESSOR SERGEANT", "3", "3", "3", "3", "15"}, {"INTERCESSOR SERGEANT", "3", "3", "3", "3", "15"},
            {"ASSAULT INTERCESSOR WARRIOR", "3", "3", "3", "3", "14"}, {"ASSAULT INTERCESSOR GRENADIER", "3", "3", "3", "3", "14"},
            {"INTERCESSOR WARRIOR", "3", "3", "3", "3", "14"}, {"INTERCESSOR GUNNER", "3", "3", "3", "3", "14"},
            {"INFILTRATOR COMMSMAN", "3", "3", "3", "3", "12"}, {"INFILTRATOR HELIX ADEPT", "3", "3", "3", "3", "12"},
            {"INFILTRATOR SABOTEUR", "3", "3", "3", "3", "12"}, {"INFILTRATOR VETERAN", "3", "3", "3", "3", "12"},
            {"INFILTRATOR VOXBREAKER", "3", "3", "3", "3", "12"}, {"INFILTRATOR WARRIOR", "3", "3", "3", "3", "12"},
            {"INFILTRATOR SERGEANT", "3", "3", "3", "3", "13"}, {"INCURSOR MARKSMAN", "3", "3", "3", "3", "12"},
            {"INCURSOR MINELAYER", "3", "3", "3", "3", "12"}, {"INCURSOR WARRIOR", "3", "3", "3", "3", "12"},
            {"INCURSOR SERGEANT", "3", "3", "3", "3", "13"}, {"REIVER WARRIOR", "3", "3", "3", "3", "12"},
            {"REIVER SERGEANT", "3", "3", "3", "3", "13"}, {"LEGIONARY WARRIOR", "3", "3", "3", "3", "12"},
            {"LEGIONARY GUNNER", "3", "3", "3", "3", "12"}, {"LEGIONARY HEAVY GUNNER", "3", "3", "3", "3", "12"},
            {"LEGIONARY ANOINTED", "3", "3", "3", "3", "12"}, {"LEGIONARY BUTCHER", "3", "3", "3", "3", "12"},
            {"LEGIONARY SHRIVETALON", "3", "3", "3", "3", "12"}, {"LEGIONARY ICON BEARER", "3", "3", "3", "3", "12"},
            {"LEGIONARY BALEFIRE ACOLYTE", "3", "3", "3", "3", "12"}, {"LEGIONARY CHOSEN", "3", "3", "3", "3", "13"},
            {"LEGIONARY ASPIRING CHAMPION", "3", "3", "3", "3", "13"}, {"CHAOS SPACE MARINE (WARRIOR)", "3", "3", "3", "3", "12"},
            {"CHAOS SPACE MARINE (GUNNER)", "3", "3", "3", "3", "12"}, {"CHAOS SPACE MARINE (HEAVY GUNNER)", "3", "3", "3", "3", "12"},
            {"CHAOS SPACE MARINE (ICON BEARER)", "3", "3", "3", "3", "12"}, {"CHAOS SPACE MARINE ASPIRING CHAMPION", "3", "3", "3", "3", "13"},
            {"CHAOS CULTIST (FIGHTER)", "3", "2", "3", "5", "7"}, {"CHAOS CULTIST (GUNNER)", "3", "2", "3", "5", "7"},
            {"CHAOS CULTIST CHAMPION", "3", "2", "3", "5", "8"}, {"TRAITOR BRIMSTONE GRENADIER", "3", "2", "3", "5", "7"},
            {"TRAITOR BUTCHER", "3", "2", "3", "5", "8"}, {"TRAITOR COMMSMAN", "3", "2", "3", "5", "7"},
            {"TRAITOR CORPSEMAN", "3", "2", "3", "5", "7"}, {"TRAITOR ENFORCER", "3", "2", "3", "4", "8"},
            {"TRAITOR FLENSER", "3", "2", "3", "5", "7"}, {"TRAITOR GUNNER", "3", "2", "3", "5", "7"},
            {"TRAITOR OGRYN", "3", "2", "3", "5", "16"}, {"TRAITOR SHARPSHOOTER", "3", "2", "3", "5", "7"},
            {"TRAITOR THUG", "3", "2", "3", "4", "7"}, {"TRAITOR TRENCH SWEEPER", "3", "2", "3", "4", "7"},
            {"TRAITOR TROOPER", "3", "2", "3", "5", "7"}, {"TRAITOR CHIEFTAIN", "3", "2", "3", "5", "8"},
            {"CULT DEMAGOGUE", "3", "2", "3", "5", "8"}, {"BLESSED BLADE", "3", "2", "3", "5", "8"},
            {"ICONARCH", "3", "2", "3", "5", "8"}, {"MINDWITCH", "3", "2", "3", "5", "8"},
            {"CHAOS DEVOTEE", "3", "2", "3", "5", "7"}, {"CHAOS MUTANT", "3", "2", "3", "5", "7"},
            {"CHAOS TORMENT", "3", "2", "3", "5", "13"}, {"PLAGUE MARINE (WARRIOR)", "2", "3", "3", "3", "12"},
            {"PLAGUE MARINE (GUNNER)", "2", "3", "3", "3", "12"}, {"PLAGUE MARINE (HEAVY GUNNER)", "2", "3", "3", "3", "12"},
            {"PLAGUE MARINE (FIGHTER)", "2", "3", "3", "3", "12"}, {"PLAGUE MARINE (ICON BEARER)", "2", "3", "3", "3", "12"},
            {"PLAGUE MARINE CHAMPION", "2", "3", "3", "3", "13"}, {"SORCERER", "3", "3", "3", "3", "13"},
            {"RUBRIC MARINE GUNNER", "3", "3", "3", "3", "12"}, {"RUBRIC MARINE ICON BEARER", "3", "3", "3", "3", "12"},
            {"RUBRIC MARINE WARRIOR", "3", "3", "3", "3", "12"}, {"TZAANGOR CHAMPION", "3", "2", "3", "6", "8"},
            {"TZAANGOR FIGHTER", "3", "2", "3", "6", "8"}, {"TZAANGOR HORN BEARER", "3", "2", "3", "6", "8"},
            {"TZAANGOR ICON BEARER", "3", "2", "3", "6", "8"}, {"VOIDSCARRED WARRIOR", "3", "2", "3", "4", "8"},
            {"VOIDSCARRED GUNNER", "3", "2", "3", "4", "8"}, {"VOIDSCARRED HEAVY GUNNER", "3", "2", "3", "4", "8"},
            {"VOIDSCARRED STARSTORM DUELLIST", "3", "2", "3", "4", "8"}, {"VOIDSCARRED KURNITE HUNTER", "3", "2", "3", "4", "8"},
            {"VOIDSCARRED SHADE RUNNER", "3", "2", "3", "4", "8"}, {"VOIDSCARRED KURNATHI", "3", "2", "3", "4", "8"},
            {"VOIDSCARRED FATE DEALER", "3", "2", "3", "4", "8"}, {"VOIDSCARRED WAY SEEKER", "3", "2", "3", "4", "8"},
            {"VOIDSCARRED SOUL WEAVER", "3", "2", "3", "4", "8"}, {"VOIDSCARRED FELARCH", "3", "2", "3", "4", "9"},
            {"GUARDIAN DEFENDER (WARRIOR)", "3", "2", "3", "4", "8"}, {"GUARDIAN DEFENDER (HEAVY GUNNER)", "3", "2", "3", "4", "8"},
            {"GUARDIAN DEFENDER HEAVY WEAPON PLATFORM", "2", "0", "3", "3", "12"}, {"GUARDIAN DEFENDER (LEADER)", "3", "2", "3", "4", "9"},
            {"STORM GUARDIAN (WARRIOR)", "3", "2", "3", "4", "8"}, {"STORM GUARDIAN (GUNNER)", "3", "2", "3", "4", "8"},
            {"STORM GUARDIAN (LEADER)", "3", "2", "3", "4", "9"}, {"RANGER (WARRIOR)", "3", "2", "3", "5", "8"},
            {"RANGER (LEADER)", "3", "2", "3", "5", "9"}, {"DIRE AVENGER (WARRIOR)", "3", "2", "3", "4", "8"},
            {"DIRE AVENGER EXARCH", "3", "2", "3", "4", "9"}, {"KABALITE (WARRIOR)", "3", "2", "3", "4", "8"},
            {"SYBARITE", "3", "2", "3", "4", "9"}, {"KABALITE (GUNNER)", "3", "2", "3", "4", "8"},
            {"KABALITE (HEAVY GUNNER)", "3", "2", "3", "4", "8"}, {"WYCH (WARRIOR)", "3", "2", "3", "6", "8"},
            {"HEKATRIX", "3", "2", "3", "6", "9"}, {"WYCH (FIGHTER)", "3", "2", "3", "6", "8"},
            {"KABALITE ARCHSYBARITE", "3", "2", "3", "4", "9"}, {"KABALITE AGENT", "3", "2", "3", "4", "8"},
            {"KABALITE CRIMSON DUELLIST", "3", "2", "3", "4", "8"}, {"KABALITE DISCIPLE OF YAELINDRA", "3", "2", "3", "4", "8"},
            {"KABALITE ELIXICANT", "3", "2", "3", "4", "8"}, {"KABALITE FLAYER", "3", "2", "3", "4", "8"},
            {"KABALITE GUNNER", "3", "2", "3", "4", "8"}, {"KABALITE HEAVY GUNNER", "3", "2", "3", "4", "8"},
            {"KABALITE SKYSPLINTER ASSASSIN", "3", "2", "3", "4", "8"}, {"LEAD PLAYER", "3", "3", "3", "6", "9"},
            {"DEATH JESTER", "3", "3", "3", "6", "9"}, {"PLAYER", "3", "3", "3", "6", "8"},
            {"SHADOWSEER", "3", "3", "3", "6", "9"}, {"CHRONOMANCER", "3", "3", "3", "3", "13"},
            {"PSYCHOMANCER", "3", "3", "3", "3", "13"}, {"TECHNOMANCER", "3", "3", "3", "3", "13"},
            {"PLASMACYTE ACCELERATOR", "3", "2", "2", "5", "5"}, {"PLASMACYTE REANIMATOR", "3", "2", "2", "5", "5"},
            {"APPRENTEK", "3", "2", "3", "3", "12"}, {"DEATHMARK", "2", "2", "3", "3", "10"},
            {"IMMORTAL GUARDIAN", "2", "2", "3", "3", "10"}, {"NECRON WARRIOR", "2", "2", "3", "4", "9"},
            {"IMMORTAL (LEADER)", "2", "2", "3", "3", "11"}, {"FLAYED ONE (WARRIOR)", "2", "2", "3", "4", "9"},
            {"FLAYED ONE (LEADER)", "2", "2", "3", "4", "10"}, {"DEATHMARK (WARRIOR)", "2", "2", "3", "3", "10"},
            {"DEATHMARK (LEADER)", "2", "2", "3", "3", "11"}, {"BOY (FIGHTER)", "3", "2", "3", "5", "10"},
            {"BOSS NOB", "3", "2", "3", "4", "13"}, {"BOY (GUNNER)", "3", "2", "3", "5", "10"},
            {"GRETCHIN", "3", "2", "3", "6", "5"}, {"CLAN KOMMANDO (FIGHTER)", "3", "2", "3", "5", "10"},
            {"CLAN KOMMANDO NOB", "3", "2", "3", "4", "13"}, {"BURNA BOY", "3", "2", "3", "5", "10"},
            {"LOOTA", "3", "2", "3", "5", "10"}, {"SPANNER", "3", "2", "3", "5", "11"},
            {"KOMMANDO BOY", "3", "2", "3", "5", "10"}, {"KOMMANDO SLASHA BOY", "3", "2", "3", "5", "10"},
            {"KOMMANDO BREACHA BOY", "3", "2", "3", "5", "10"}, {"KOMMANDO SNIPA BOY", "3", "2", "3", "5", "10"},
            {"KOMMANDO DAKKA BOY", "3", "2", "3", "5", "10"}, {"KOMMANDO COMMS BOY", "3", "2", "3", "5", "10"},
            {"KOMMANDO BURNA BOY", "3", "2", "3", "5", "10"}, {"KOMMANDO ROKKIT BOY", "3", "2", "3", "5", "10"},
            {"KOMMANDO GROT", "3", "2", "3", "5", "5"}, {"KOMMANDO NOB", "3", "2", "3", "4", "13"},
            {"BOMB SQUIG", "3", "2", "3", "6", "6"}, {"FIRE WARRIOR SHASLA", "3", "2", "3", "4", "7"},
            {"FIRE WARRIOR SHASUI", "3", "2", "3", "4", "8"}, {"PATHFINDER SHASLA", "3", "2", "3", "5", "7"},
            {"PATHFINDER (HEAVY GUNNER)", "3", "2", "3", "5", "7"}, {"PATHFINDER SHASUI", "3", "2", "3", "5", "8"},
            {"STEALTH BATTLESUIT SHASUI", "3", "2", "3", "3", "10"}, {"STEALTH BATTLESUIT SHASVRE", "3", "2", "3", "3", "11"},
            {"MV1 GUN DRONE", "3", "2", "3", "4", "7"}, {"MV4 SHIELD DRONE", "3", "2", "3", "4", "7"},
            {"MV36 GUARDIAN DRONE", "3", "2", "3", "4", "7"}, {"MV31 PULSE ACCELERATOR DRONE", "3", "2", "3", "4", "7"},
            {"MV33 GRAV INHIBITOR DRONE", "3", "2", "3", "4", "7"}, {"MV7 MARKER DRONE", "3", "2", "3", "4", "7"},
            {"MB3 RECON DRONE", "3", "2", "3", "4", "12"}, {"DS8 TACTICAL SUPPORT TURRET", "0", "1", "3", "4", "9"},
            {"SHASUI PATHFINDER", "3", "2", "3", "5", "8"}, {"SHASLA PATHFINDER", "3", "2", "3", "5", "7"},
            {"BLOODED PATHFINDER", "3", "2", "3", "4", "7"}, {"DRONE CONTROLLER PATHFINDER", "3", "2", "3", "5", "7"},
            {"TRANSPECTRAL INTERFERENCE PATHFINDER", "3", "2", "3", "5", "7"}, {"ASSAULT GRENADIER PATHFINDER", "3", "2", "3", "5", "7"},
            {"COMMUNICATIONS SPECIALIST PATHFINDER", "3", "2", "3", "5", "7"}, {"MEDICAL TECHNICIAN PATHFINDER", "3", "2", "3", "5", "7"},
            {"WEAPONS EXPERT PATHFINDER", "3", "2", "3", "5", "7"}, {"MARKSMAN PATHFINDER", "3", "2", "3", "5", "7"},
            {"MB3 RECON DRONE", "3", "2", "3", "4", "12"}, {"MV1 GUN DRONE", "3", "2", "3", "4", "7"},
            {"MV4 SHIELD DRONE", "3", "2", "3", "4", "7"}, {"MV7 MARKER DRONE", "3", "2", "3", "4", "7"},
            {"MV31 PULSE ACCELERATOR DRONE", "3", "2", "3", "4", "7"}, {"MV33 GRAV INHIBITOR DRONE", "3", "2", "3", "4", "7"}
    };
    /*!MINIATURES*/

    /*LOCATIONS*/
    public static final String[] LOCATION_VALUES = {
            "Игровой Альянс, Игровой Альянс Невский проспект, дом 25",
            "Досочные Стратегии, Улица Рубинштейна, дом 14",
            "Карточная Гармония, Большой проспект Васильевского острова, дом 45",
            "Кубиковый Рай, Литейный проспект, дом 10",
            "Игровая Галактика, Пушкинская улица, дом 8",
            "Ролевой Ход, Профессора Попова улица, дом 22",
            "Кубок Легенд, Большая Морская улица, дом 5",
            "Тактический Скиталец, Московский проспект, дом 36",
            "Настольные Герои, Восстания улица, дом 17",
            "Шестигранный Анклав, Плотинная улица, дом 3"
    };
    /*!LOCATIONS*/

    /*NAMES*/
    public static final String[] MALE_NAMES = {
            "Александр", "Дмитрий", "Иван", "Михаил", "Сергей", "Андрей", "Владимир", "Николай",
            "Павел", "Артем", "Егор", "Антон", "Григорий", "Виктор", "Максим", "Юрий", "Денис",
            "Василий", "Роман", "Вячеслав", "Олег", "Игорь", "Тимофей", "Алексей", "Виталий"
    };

    public static final String[] FEMALE_NAMES = {
            "Екатерина", "Ольга", "Анна", "Наталья", "Мария", "Татьяна", "Елена", "Ирина",
            "Светлана", "Ангелина", "Александра", "Виктория", "Надежда", "Юлия",
            "Алина", "Евгения", "Оксана", "Анастасия", "Валентина", "Лариса",
            "Галина", "Тамара", "Маргарита", "Людмила", "Дарья"
    };

    public static final String[] MALE_SURNAMES = {
            "Иванов", "Смирнов", "Петров", "Соколов", "Кузнецов", "Васильев", "Морозов",
            "Новиков", "Федоров", "Волков", "Козлов", "Лебедев", "Семенов", "Егоров",
            "Павлов", "Козлов", "Сергеев", "Макаров", "Андреев", "Захаров", "Дмитриев",
            "Гусев", "Киселев", "Ильин", "Максимов"
    };

    public static final String[] FEMALE_SURNAMES = {
            "Иванова", "Смирнова", "Петрова", "Соколова", "Кузнецова", "Васильева", "Морозова",
            "Новикова", "Федорова", "Волкова", "Козлова", "Лебедева", "Семенова", "Егорова",
            "Павлова", "Козлова", "Сергеева", "Макарова", "Андреева", "Захарова", "Дмитриева",
            "Гусева", "Киселева", "Ильина", "Максимова"
    };

    public static final String[] MALE_MIDDLENAMES = {
            "Иванович",
            "Петрович",
            "Александрович",
            "Дмитриевич",
            "Сергеевич",
            "Николаевич",
            "Анатольевич",
            "Артемович",
            "Владимирович",
            "Егорович",
            "Михайлович",
            "Арсеньевич",
            "Валентинович",
            "Геннадьевич",
            "Романович",
            "Викторович",
            "Ярославович",
            "Игоревич",
            "Константинович",
            "Тимофеевич",
            "Федорович",
            "Леонидович",
            "Валерьевич",
            "Олегович",
            "Станиславович"
    };

    public static final String[] FEMALE_MIDDLENAMES = {
            "Ивановна",
            "Петровна",
            "Александровна",
            "Дмитриевна",
            "Сергеевна",
            "Николаевна",
            "Анатольевна",
            "Артемовна",
            "Владимировна",
            "Егоровна",
            "Михайловна",
            "Арсеньевна",
            "Валентиновна",
            "Геннадьевна",
            "Романовна",
            "Викторовна",
            "Ярославовна",
            "Игоревна",
            "Константиновна",
            "Тимофеевна",
            "Федоровна",
            "Леонидовна",
            "Валерьевна",
            "Олеговна",
            "Станиславовна"
    };
    /*!NAMES*/

    /*RULES EDITION*/
    public static final int RULES_EDITION_LOW = 1;
    public static final int RULES_EDITION_HIGH = 10;
    /*!RULES EDITION*/
}
