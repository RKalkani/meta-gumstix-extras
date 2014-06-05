# This recipe is based on the version from meta-arago
require ${COREBASE}/meta/recipes-qt/qt4/qt4-${PV}.inc
require ${COREBASE}/meta/recipes-qt/qt4/qt4-embedded.inc

PROVIDES += "qt4-embedded"
RPROVIDES_${PN} += "qt4-embedded"
RPROVIDES_${PN}-dev += "qt4-embedded-dev"

# We need the accelerated version of virtual/egl
DEPENDS_duovero += "libgles-omap4"
DEPENDS_overo += "libgles-omap3"
DEPENDS_pepper += "libgles-omap3"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:${COREBASE}/meta/recipes-qt/qt4/qt4-${PV}"

SRC_URI += " \
    file://0001-wsegl2-support.patch \
    file://002_pvrqwswsegl.c.patch \
    file://cursor-hack.diff \
    file://0001-Qt-4.x-v2-Changes-for-integrating-with-TI-graphics-S.patch \
    file://linux.conf \
"

CONFFILES_${PN} = "${sysconfdir}/powervr.ini"

QT_CONFIG_FLAGS_append_arm = "${@bb.utils.contains("TUNE_FEATURES", "neon", "", " -no-neon" ,d)}"

QT_CONFIG_FLAGS += " \
 -exceptions \
"

QT_GLFLAGS = "-opengl es2 -depths 16,24,32 -plugin-gfx-powervr -D QT_QWS_CLIENTBLIT"

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "[default]" > ${D}${sysconfdir}/powervr.ini
        echo "WindowSystem=libpvrQWSWEGL.so" >> ${D}${sysconfdir}/powervr.ini
}
