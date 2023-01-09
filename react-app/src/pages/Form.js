import { useForm } from "react-hook-form"
import Header from "../component/Header"
import 'bootstrap/dist/css/bootstrap.css'

export default function Form() {
    const { register, formState: { errors }, handleSubmit } = useForm();
    const onSubmit = (data) => submit(data);
    return (
        <div>
            <Header />

            <div className="container align-item-center">
                <div className="row justify-content-center">
                    <div className="col-md-6 mb-3">
                        <form
                            onSubmit={handleSubmit(onSubmit)}
                            style={{ marginLeft: "40px", marginTop: "30px" }}>

                            <span>Nama Lengkap</span>
                            <input
                                className="form-control md-3 mb-2 mt-2"
                                {...register("nama_lengkap", { required: true, pattern: /^[A-Za-z]+$/i })}
                                aria-invalid={errors.nama_lengkap ? "true" : "false"}
                            />
                            {errors.nama_lengkap?.type === 'required' && <p role="alert" style={{ color: "red" }}>Nama harus diisi</p>}
                            {errors.nama_lengkap?.type === 'pattern' && <p role="alert" style={{ color: "red" }}>Nama Lengkap harus berupa huruf</p>}

                            <span>Email</span>
                            <input
                                className="form-control md-3 mb-2 mt-2"
                                {...register("email", { required: true, pattern: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i })}
                                aria-invalid={errors.mail ? "true" : "false"}
                            />
                            {errors.email?.type === "required" && <p role="alert" style={{ color: "red" }}>Email harus diisi</p>}
                            {errors.email?.type === "pattern" && <p role="alert" style={{ color: "red" }}>Email tidak sesuai</p>}

                            <span>No handphone</span>
                            <input
                                className="form-control md-3 mb-2 mt-2"
                                type="number" min="0"
                                {...register("no_handphone", { required: true, minLength: 10, maxLength: 13 })}
                                aria-invalid={errors.no_handphone ? "true" : "false"}
                            />
                            {errors.no_handphone?.type === 'required' && <p role="alert" style={{ color: "red" }}>No Handphone harus diisi</p>}
                            {errors.no_handphone?.type === 'minLength' && <p role="alert" style={{ color: "red" }}>No Handphone minimal 10 angka</p>}
                            {errors.no_handphone?.type === 'maxLength' && <p role="alert" style={{ color: "red" }}>No Handphone maksimal 13 angka</p>}

                            <span>Latar Belakang Pendidikan</span>
                            <div style={{ marginLeft: "20px" }}>
                                <div>
                                    <input {...register("latar_belakang")}
                                        className="form-check-input"
                                        type="radio"
                                        value="IT"
                                        defaultChecked
                                    />
                                    <label className="form-check-label">
                                        IT
                                    </label>
                                </div>

                                <div>
                                    <input {...register("latar_belakang")}
                                        className="form-check-input"
                                        type="radio"

                                        value="Non IT"
                                    />
                                    <label className="form-check-label mb-2">
                                        Non IT
                                    </label>
                                </div>
                            </div>

                            <span>Kelas Coding yang Dipilih</span>
                            <select className="form-select md-3 mb-2 mt-2" {...register("kelas_coding")}>
                                <option value="">Pilih salah satu program</option>
                                <option value="Backend Engineer">Backend Engineer</option>
                                <option value="Frontend Engineer">Frontend Engineer</option>
                                <option value="Fullstack Engineer">Fullstack Engineer</option>
                            </select>

                            <span>Foto Surat Kesungguhan</span>

                            <input
                                className="form-control md-3 mb-2 mt-2"
                                {...register("image", { required: true })} type="file" name="image" />
                            {errors.image?.type === 'required' && <p role="alert" style={{ color: "red" }}>Gambar harus diisi</p>}

                            <span>Harapan untuk Coding Bootcamp ini:</span>
                            <textarea
                                className="form-control md-3 mb-2 mt-2"
                                style={{ height: "100px" }}
                                {...register("harapan", { required: true })} />
                            {errors.image?.type === 'required' && <p role="alert" style={{ color: "red" }}>Harapan harus diisi</p>}

                            <div style={{ marginTop: "20px" }}>
                                <input className="btn btn-success btn-sm" type="submit" style={{ marginRight: "10px" }} />
                                <input className="btn btn-danger btn-sm" type="reset" />
                            </div>

                        </form >
                    </div>
                </div>
            </div >
        </div >
    );

    function submit(data) {
        data.image = data.image[0].name
        console.log(JSON.stringify(data))
        alert(
            "Data pendaftar " + data.nama_lengkap + " berhasil diterima"
        )
    }
}
