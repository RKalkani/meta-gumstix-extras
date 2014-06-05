DESCRIPTION = "Library for the DRI2 extension to the X Window System"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=827da9afab1f727f2a66574629e0f39c"

SRC_URI[md5sum] = "0e0a1f08b10abf00f139d1a1f0a9937c"
SRC_URI[sha256sum] = "9ce0478b3c1cf49821688978159a4f960941ec695fd9e535dc53c9714c43f673"

SRCREV="5c90ba76540c2b7da7d0d3ad46a9ac0ee7681382"
SRC_URI = " \
    git://gitorious.org/ubuntu-omap/libdri2 \
"

S = "${WORKDIR}/git"

DEPENDS = "libx11 libdrm"
