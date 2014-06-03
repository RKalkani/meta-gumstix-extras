FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE = "overo|pepper"

# Counteract meta-ti's preference for 4.05.00.03
DEFAULT_PREFERENCE_overo = "100"

SRC_URI += " \
    file://0001-Cleanup-permissions-and-compilation-detritus.patch \
    file://0002-Allow-user-to-specify-KERNELDIR.patch \
    file://0003-Add-include-patch-for-omapfb-omapfb.h-with-3.15.patch \
    file://0004-Disable-use-of-vsync_callback_t.patch \
    file://0005-Convert-ioremap_cached-to-ioremap_cache.patch \
    file://0006-Adapt-OMAP_DSS_MANAGER-for-3.12.2-kernels.patch \
    file://0007-Remove-unused-variables-causing-warnings.patch \
    file://0008-Correct-references-to-plat-gpu.h-dmtimer.h-for-OMAP4.patch \
    file://0009-Cleanup-include-paths-for-SUPPORT_XORG-1.patch \
    file://0010-Assume-TI_PLATFORM-omap3-means-OMAPES-3.x.patch \
    file://0011-Get-rid-of-reference-to-asm-system.h.patch \
    file://0012-Change-files-compiled-for-drm.ko.patch \
    file://0013-Get-rid-of-unused-drm_fasync.patch \
    file://0014-Make-reset-conditional-on-CONFIG_-not-kernel-version.patch \
"
