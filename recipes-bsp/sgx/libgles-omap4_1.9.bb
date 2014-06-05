DESCRIPTION = "OpenGLES Libraries for SGX540 GPU on OMAP4430 & OMAP4460 SoCs"
LICENSE = "proprietary-binary"
LIC_FILES_CHKSUM = "file://license.txt;md5=a9b2fa6b5a8bd374764f60b71cb550a6"

COMPATIBLE_MACHINE = "omap4"
DEPENDS = "virtual/libx11 libxdmcp libdri2"
RDPENDS = "virtual/libx11"

PROVIDES += "libgles-omap4 virtual/egl virtual/libgles1 virtual/libgles2"

RRECOMMENDS_${PN} += "sgx-modules"

RREPLACES_${PN} = "libegl libgles1 libgles2"
RPROVIDES_${PN} = "libegl libgles1 libgles2"
RCONFLICTS_${PN} = "libegl libgles1 libgles2"

SRC_URI = " \
    https://launchpad.net/~tiomap-dev/+archive/omap-trunk/+files/pvr-omap4_1.9.0.7.1.5.orig.tar.gz \
"
SRC_URI[md5sum] = "fe4f7101e7ecbf524cc4b2e381854bd9"
SRC_URI[sha256sum] = "8822ca9472f099be06b1f6526711c0f949b0496056aad6fa67b04c5f8653c5ba"


S = "${WORKDIR}"

do_compile[noexec] = "1"

do_install() {
	mkdir -p ${D}/usr
	cp -r ${S}/usr/* ${D}/usr/
}
FILES_${PN} += "${libdir}/debug/* usr/share/* ${libdir}/xorg/* ${libdir}/gbm/*"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP_${PN} = "ldflags already-stripped useless-rpaths dev-so"
