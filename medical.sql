/*
 Navicat Premium Data Transfer

 Source Server         : service7
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : service.cf:3307
 Source Schema         : medical

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 08/05/2022 16:09:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `medicals_id` bigint(20) NOT NULL COMMENT '医疗内容id',
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 1, 1, '学到了！学到了！', '2022-05-08 16:02:06', '2022-05-08 16:02:06');

-- ----------------------------
-- Table structure for medicals
-- ----------------------------
DROP TABLE IF EXISTS `medicals`;
CREATE TABLE `medicals`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `files` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文件集合',
  `type` tinyint(2) NOT NULL DEFAULT 1 COMMENT '类型（1-典籍 2-经络 3-医方 4-穴位）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医疗内容' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medicals
-- ----------------------------
INSERT INTO `medicals` VALUES (1, '《黄帝内经》', '《黄帝内经》分《灵枢》、《素问》两部分，是中国最早的医学典籍，传统医学四大经典著作之一（其余三者为《难经》、《伤寒杂病论》、《神农本草经》）《黄帝内经》是一本综合性的医书，在黄老道家理论上建立了中医学上的“阴阳五行学说”、“脉象学说”、“藏象学说”、“经络学说”、“病因学说”、“病机学说”、“病症”、“诊法”“论治”及“养生学”、“运气学”等学说，从整体观上来论述医学，呈现了自然、生物、心理、社会“整体医学模式”（另据现代学者考证，认为今本中的黄老道家痕迹是隋唐时期的道士王冰窜入 [1-2]  ）。 其基本素材来源于中国古人对生命现象的长期观察、大量的临床实践以及简单的解剖学知识。《黄帝内经》奠定了人体生理、病理、诊断以及治疗的认识基础，是中国影响极大的一部医学著作，被称为医之始祖。 [3] 《黄帝内经》作为《中华优秀传统文化百部经典》之一，2021年已经推出', 'https://minio.service.cf/file/QQ%E6%88%AA%E5%9B%BE20220508153949-85bee5c380f948b7b5ea5b6b5340fff4.png', 1, '2022-05-08 15:41:35', '2022-05-08 15:41:35');
INSERT INTO `medicals` VALUES (2, '手太阴肺经', '起于中焦，向下联络大肠，回绕过来沿着胃的上口，通过横膈，属于肺脏，从“肺系”（肺与喉咙相联系的部位）横行出来（中府），向下沿上臂内侧，行于手少阴经和手厥阴经的前面，下行到肘窝中，沿着前臂内侧前缘，进入寸口，经过鱼际，沿着鱼际的边缘，出拇指内侧端（少商）。', 'https://bkimg.cdn.bcebos.com/pic/bf096b63f6246b6050156b7bebf81a4c510fa2a2?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', 2, '2022-05-08 16:05:25', '2022-05-08 16:06:07');
INSERT INTO `medicals` VALUES (3, '手阳明大肠经', '本经起于食指桡侧端(商阳穴)，经过手背行于上肢伸侧前缘，上肩，至肩关节前缘，向后与督脉在大椎穴处相会，再向前下行入锁骨上窝(缺盆)，进入胸腔络肺，通过膈肌下行，入属大肠。其分支从锁骨上窝上行，经颈部至面颊，入下齿中，回出夹口两旁，左右交叉于人中，至对侧鼻翼旁，经气于迎香穴处与足阳明胃经相接。', 'https://bkimg.cdn.bcebos.com/pic/94cad1c8a786c91727970438c93d70cf3bc7571e?x-bce-process=image/resize,m_lfit,h_168,limit_1/format,f_auto', 2, '2022-05-08 16:05:25', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (4, '足阳明胃经', '起于鼻翼两侧（迎香），上行到鼻根部，与旁侧足太阳经交会，向下沿着鼻的外侧（承泣），进入上齿龈内，回出环绕口唇，向下交会于颏唇沟承浆（任脉）处，再向后沿着口腮后下方，出于下颌大迎处，沿着下颌角颊车，上行耳前，经过上关（足少阳经），沿着发际，到达前额（神庭）；', 'https://bkimg.cdn.bcebos.com/pic/3ac79f3df8dcd100da0aae20728b4710b9122f18?x-bce-process=image/resize,m_lfit,w_987,limit_1/format,f_auto', 2, '2022-05-08 16:05:25', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (5, '足太阴脾经', '起于足大趾末端（隐白），沿着大趾内侧赤白肉际，经过大趾本节后的第一跖趾关节后面，上行至内踝前面，再上腿肚，沿着胫骨后面，交出足厥阴经的前面，经膝股部内侧前缘，进入腹部，属于脾脏，联络胃，通过横膈上行，挟咽部两旁，连系舌根，分散于舌下；', 'https://bkimg.cdn.bcebos.com/pic/adaf2edda3cc7cd99bbd62d83901213fb80e911a?x-bce-process=image/resize,m_lfit,w_967,limit_1/format,f_auto', 2, '2022-05-08 16:05:25', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (6, '手少阴心经', '起于心中，出属“心系”（心与其他脏器相连系的部位），通过横膈，联络小肠；', 'https://bkimg.cdn.bcebos.com/pic/adaf2edda3cc7cd99bbd62d83901213fb80e911a?x-bce-process=image/resize,m_lfit,w_967,limit_1/format,f_auto', 2, '2022-05-08 16:05:25', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (7, '手太阳小肠经', '起于于小指外侧端（少泽），沿着手背外侧至腕部，出于尺骨茎突，直上沿着前臂外侧后缘，经尺骨鹰嘴与肱骨内上髁之间，沿上臂外侧后缘，出于肩关节，绕行肩胛部，交会于大椎（督脉），向下进入缺盆部，联络心脏，沿着食管通过横膈，到达胃部，属于小肠；', 'https://bkimg.cdn.bcebos.com/pic/e4dde71190ef76c68f5dad2a9d16fdfaaf516727?x-bce-process=image/resize,m_lfit,w_641,limit_1/format,f_auto', 2, '2022-05-08 16:05:25', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (8, '足太阳膀胱经', '起于目内眦（睛明），上额交会于巅顶（百会，属督脉）；', 'https://bkimg.cdn.bcebos.com/pic/e4dde71190ef76c68f5dad2a9d16fdfaaf516727?x-bce-process=image/resize,m_lfit,w_641,limit_1/format,f_auto', 2, '2022-05-08 16:05:26', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (9, '足少阴肾经', '起于足小趾之下，斜向足心（涌泉），出于舟骨粗隆下，沿内踝后，进入足跟，再向上行于腿肚内侧，出腘窝的内侧，向上行股内后缘，通向脊柱（长强，属督脉），属于肾脏（腧穴通路：还出于前，向上行腹部前正中线旁开0.5寸，胸部前正中线旁开2寸，终止于锁骨下缘俞府穴），联络膀胱；', 'https://bkimg.cdn.bcebos.com/pic/8cb1cb1349540923e3e5357f9258d109b3de4926?x-bce-process=image/resize,m_lfit,w_989,limit_1/format,f_auto', 2, '2022-05-08 16:05:26', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (10, '手厥阴心包经', '起于胸中，出属心包络，向下通过横膈，从胸至腹依次联络上、中、下三焦；', 'https://bkimg.cdn.bcebos.com/pic/8cb1cb1349540923e3e5357f9258d109b3de4926?x-bce-process=image/resize,m_lfit,w_989,limit_1/format,f_auto', 2, '2022-05-08 16:05:26', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (11, '手少阳三焦经', '起于无名指末端（关冲）向上出于第四、五掌骨间，沿着腕背，出于前臂外侧桡骨和尺骨之间，向上通过肘尖，沿上臂外侧，上达肩部，交出足少阳经的后面，向前进人缺盆部，分布于胸中，联络心包，向下通过横膈，从胸至腹，属上、中、下三焦；', 'https://bkimg.cdn.bcebos.com/pic/b21bb051f81986189fd5b9854aed2e738bd4e625?x-bce-process=image/resize,m_lfit,w_1029,limit_1/format,f_auto', 2, '2022-05-08 16:05:26', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (12, '足少阳胆经', '起于目外眦（瞳子髎），向上到达额角部（颔厌），下行至耳后（风池），沿着颈部行于手少阳经的前面，到肩上交出手少阳经的后面，向下进入缺盆部；', 'https://bkimg.cdn.bcebos.com/pic/3c6d55fbb2fb4316b5b9107b20a4462309f7d309?x-bce-process=image/resize,m_lfit,w_980,limit_1/format,f_auto', 2, '2022-05-08 16:05:26', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (13, '足厥阴肝经', '起于足大趾上毫毛部（大敦丫），沿着足跗部向上，经过内踝前一寸处（中封），向上至内踝上八寸处交出于足太阴经的后面，上行膝内侧，沿着股部内侧，进入阴毛中，绕过阴部，上达小腹，挟着胃旁，属于肝脏，联络胆腑，向上通过横膈，分布于胁肋，沿着喉咙的后面，向上进入鼻咽部，连接于“目系” （眼球连系于脑的部位），向上出于前额，与督脉会合于巅顶；', 'https://bkimg.cdn.bcebos.com/pic/bf096b63f6246b60c17ff6d8e1f81a4c510fa22d?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', 2, '2022-05-08 16:05:26', '2022-05-08 16:06:08');
INSERT INTO `medicals` VALUES (14, '安卧如神汤', '茯苓1钱，茯神1钱，白术1钱，山药1钱，寒水石（段）1钱，枣仁1钱，远志7分，炙草7分，朱砂5分，人参4分。​', NULL, 3, '2022-05-08 16:07:34', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (15, '补中益气汤', '黄芪15g、人参(党参)15g、白术10g、炙甘草15g、当归10g、陈皮6g、升麻6g、柴胡12g、生姜9片、大枣6枚。', NULL, 3, '2022-05-08 16:07:34', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (16, '四君子汤', '人参、白术、茯苓各9g，甘草6g。', NULL, 3, '2022-05-08 16:07:34', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (17, '参苓白术散', '白扁豆、白术、茯苓、甘草、桔梗、莲子、人参、砂仁、山药、薏苡仁。', NULL, 3, '2022-05-08 16:07:34', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (18, '龟鹿二仙膏', '鹿角(新鲜麋鹿杀，角解的不用，马鹿角不用，去角脑梢骨二寸绝断，劈开，净用)5000g，龟板(去弦，洗净，捶碎)2500g，人参450g，枸杞子900g。', NULL, 3, '2022-05-08 16:07:34', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (19, '大补阴丸', '熟地黄，盐知母、盐黄柏、醋龟甲、猪脊髓。', NULL, 3, '2022-05-08 16:07:34', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (20, '天王补心丹', '人参(去芦)、茯苓、玄参、丹参、桔梗、远志各15g，当归(酒浸)、五味子、麦门冬(去心)、天门冬、柏子仁、酸枣仁(炒)各30g，生地黄120g。', NULL, 3, '2022-05-08 16:07:35', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (21, '人参固本丸', '生地黄（洗）熟地黄（洗再蒸）天冬（去皮）麦冬（去心）各30克 人参15克（经验秘方、良方、寿亲养老新书各30克）', NULL, 3, '2022-05-08 16:07:35', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (22, '三才封髓丹', '太子参30g,山慈菇30g,生地15g, 熟地15g,天冬9g,麦冬9g,砂仁9g,黄柏9g, 甘草9g,黑山梔9g,草河车9g。', NULL, 3, '2022-05-08 16:07:35', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (23, '虎潜丸', '虎胫骨30g，牛膝60g，陈皮60g，熟地90g，锁阳45g，龟板120g，干姜30g，当归45g，知母90g，黄柏90g，白芍60g。', NULL, 3, '2022-05-08 16:07:35', '2022-05-08 16:07:39');
INSERT INTO `medicals` VALUES (24, '七宝美髯丹', '赤、白何首乌(米泔水浸三四日，瓷片刮去皮，用淘净黑豆二升，以砂锅木甑，铺豆及首乌，重重铺盖蒸之，豆熟取出，去豆晒干，换豆再蒸，如此九次，晒干，为末)各500g，赤、白茯苓(去皮，研末，以水淘去筋膜及浮者，取沉者捻块，以人乳十碗浸匀，晒干，研末)各500g，牛膝 (去苗，酒浸一日，同何首乌第七次蒸之，至第九次止，晒干)、当归 (酒浸，晒)、枸杞子(酒浸，晒)、菟丝子 (酒浸生芽，研烂，晒)各240g，补骨脂 (黑脂麻炒香)120g。', NULL, 3, '2022-05-08 16:07:35', '2022-05-08 16:07:40');
INSERT INTO `medicals` VALUES (25, '六味地黄丸', '熟地黄、酒萸肉、牡丹皮、山药、茯苓、泽泻', NULL, 3, '2022-05-08 16:07:35', '2022-05-08 16:07:40');
INSERT INTO `medicals` VALUES (26, '手太阴肺经', '本经腑穴主治喉、胸、肺病，以及经脉循行部位的其他病证。如咳嗽，气喘，少气不足以息，咳血，伤风，胸部胀满，咽喉肿痛，缺盆部及手臂内侧前缘痛，肩背寒冷、疼痛等证。', 'https://bkimg.cdn.bcebos.com/pic/7aec54e736d12f2ef5a1a8324cc2d5628535683f?x-bce-process=image/resize,m_lfit,w_235,h_235,limit_1/format,f_auto', 4, '2022-05-08 16:08:13', '2022-05-08 16:08:25');
INSERT INTO `medicals` VALUES (27, '手阳明大肠经', '本经腧穴主治头面、五官疾患，热病，皮肤病，肠胃病，神智病及经脉循行部位的其他病证。如腹痛，腹鸣腹泻、大肠功能减弱、肩膀僵硬、皮肤无光泽、肩酸、喉干、喘息、宿便，腹胀、易便秘、易患痔疮、肩背部不适或疼痛、牙疼、皮肤异常、上脘异常等。', 'https://bkimg.cdn.bcebos.com/pic/94cad1c8a786c91727970438c93d70cf3bc7571e?x-bce-process=image/resize,m_lfit,h_168,limit_1/format,f_auto', 4, '2022-05-08 16:08:13', '2022-05-08 16:08:25');
INSERT INTO `medicals` VALUES (28, '足阳明胃经', '本经腧穴主治胃肠病、头面、目、鼻、口、齿痛、神志病及经脉循行部位的其他病证。如肠鸣腹胀，水肿，胃痛，呕吐或消谷善饥，口渴，咽喉肿痛，鼻衄，胸部及膝膑等本经循行部位疼痛，热病，发狂等病证。', 'https://bkimg.cdn.bcebos.com/pic/3ac79f3df8dcd100da0aae20728b4710b9122f18?x-bce-process=image/resize,m_lfit,w_987,limit_1/format,f_auto', 4, '2022-05-08 16:08:13', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (29, '足太阴脾经', '本经腧穴主治脾胃病，妇科，前阴病及经脉循行部位的其他病证。如胃脘痛，食则呕，嗳气，腹胀便溏，黄疸，身重无力，舌根强痛，下肢内侧肿胀，厥冷等。', 'https://bkimg.cdn.bcebos.com/pic/adaf2edda3cc7cd99bbd62d83901213fb80e911a?x-bce-process=image/resize,m_lfit,w_967,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (30, '手少阴心经', '本经腧穴主治心、胸、神志病以及经脉循行部位的其他病证。如心痛，咽干，口渴，目黄，胁痛，上臂内侧痛，手心发热等。', 'https://bkimg.cdn.bcebos.com/pic/adaf2edda3cc7cd99bbd62d83901213fb80e911a?x-bce-process=image/resize,m_lfit,w_967,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (31, '手太阳小肠经', '本经腧穴主治头、项、耳、目、咽喉病，热病，神经病以及经脉循行部位的其他病证。如少腹痛，腰脊痛引睾丸，耳聋，目黄，颊肿，咽喉肿痛，肩臂外侧后缘痛等。', 'https://bkimg.cdn.bcebos.com/pic/e4dde71190ef76c68f5dad2a9d16fdfaaf516727?x-bce-process=image/resize,m_lfit,w_641,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (32, '足太阳膀胱经', '本经腧穴主治头、项、目、背、腰、下肢部病证以及神志病，背部第一侧线的背俞穴及第二侧线相平的腧穴，主治与其相关的脏腑病证和有关的组织器官病证。如小便不通，遗尿，癫狂，疟疾，目痛，迎风流泪，鼻塞多涕，鼻血丑，头痛，项、背、腰、臀部以及下肢后侧本经循行部位疼痛等证。', 'https://bkimg.cdn.bcebos.com/pic/e4dde71190ef76c68f5dad2a9d16fdfaaf516727?x-bce-process=image/resize,m_lfit,w_641,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (33, '足少阴肾经', '本经腧穴主治妇科，前阴病，肾、肺、咽喉病及经脉循行部位的其他病证。如：咳血，气喘，舌干，咽喉肿痛，水肿，大便秘结，泄泻，腰痛，脊股内后侧痛，痿弱无力，足心热等病证。', 'https://bkimg.cdn.bcebos.com/pic/8cb1cb1349540923e3e5357f9258d109b3de4926?x-bce-process=image/resize,m_lfit,w_989,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (34, '手厥阴心包经', '本经腧穴主治心、胸、胃、神志病以及经脉循行部位的其他病证。如心痛，胸闷，心悸，心烦，癫狂，腋肿，肘臂挛急等证。', 'https://bkimg.cdn.bcebos.com/pic/8cb1cb1349540923e3e5357f9258d109b3de4926?x-bce-process=image/resize,m_lfit,w_989,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (35, '手少阳三焦经', '本经腧穴主治侧头、耳、目、胸胁、咽喉病，热病以及经脉循行部位的其他病证。如腹胀，水肿，遗尿，小便不利，耳鸣，耳聋，咽喉肿痛，目赤肿痛，颊肿，耳后、肩臂肘部外侧疼痛等证。', 'https://bkimg.cdn.bcebos.com/pic/b21bb051f81986189fd5b9854aed2e738bd4e625?x-bce-process=image/resize,m_lfit,w_1029,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (36, '足少阳胆经', '本经腧穴主治侧头、目、耳、咽喉病，神志病，热病以及经脉循行部位的其他病证。如口苦，目眩，疟疾，头痛，颔痛，目外眦痛，缺盆部肿痛，腋下肿，胸、胁、股及下肢外侧痛，足外侧痛，足外侧发热等证。', 'https://bkimg.cdn.bcebos.com/pic/3c6d55fbb2fb4316b5b9107b20a4462309f7d309?x-bce-process=image/resize,m_lfit,w_980,limit_1/format,f_auto', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');
INSERT INTO `medicals` VALUES (37, '足厥阴肝经', '本经腧穴主治肝病，妇科、前阴病以及经脉循行部位的其他病证。如腰痛，胸满，呃逆，遗尿，小便不利，疝气，少腹肿等证。', 'https://bkimg.cdn.bcebos.com/pic/bf096b63f6246b60c17ff6d8e1f81a4c510fa22d?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', 4, '2022-05-08 16:08:14', '2022-05-08 16:08:26');

-- ----------------------------
-- Table structure for urls
-- ----------------------------
DROP TABLE IF EXISTS `urls`;
CREATE TABLE `urls`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '友链',
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '友情链接',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '友情链接表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of urls
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号（编号）',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `sex` int(2) NULL DEFAULT NULL COMMENT '性别（1-男 2-女）',
  `type` int(2) NULL DEFAULT 1 COMMENT '类型（1-用户 2-管理员）',
  `certificate_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `un`(`account`) USING BTREE,
  UNIQUE INDEX `un2`(`certificate_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '15516045023', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, 2, NULL, '2022-05-08 15:14:43', '2022-05-08 15:14:43');

SET FOREIGN_KEY_CHECKS = 1;
