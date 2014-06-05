DESCRIPTION = "Driver for SGX540 GPU on OMAP4430 & OMAP4460 SoCs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://sgx/MIT-COPYING;md5=8c2810fa6bfdc5ae5c15a0c1ade34054"

COMPATIBLE_MACHINE = "omap4"

inherit module

SRC_URI[md5sum] = "13152f14f2c62fda215a7ba5d927d016"
SRC_URI[sha256sum] = "3645f41267fc23a023ed05f06728135bfa6db3cabc06b27335ed42dc42ae7d8e"

SRC_URI = " \
    https://launchpad.net/~tiomap-dev/+archive/omap-trunk/+files/pvr-omap4-dkms_1.9.0.7.1.1.orig.tar.gz \
    file://0001-core-mk-fix.patch \
    file://0002-Kbuild-mk-fix.patch \
"

S = "${WORKDIR}/git-import-orig"

do_compile() {
    unset LDFLAGS && \
    oe_runmake -C sgx/eurasiacon/build/linux2/omap4430_linux \
    KERNELDIR=${STAGING_KERNEL_DIR} \
    CROSS_COMPILE=${TARGET_PREFIX} \
    SUPPORT_V4L2_GFX=0
}

do_install() {
    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
    cp  ${S}/sgx/eurasiacon/binary2_omap4430_linux_release/target/omapdrm_pvr.ko \
        ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
